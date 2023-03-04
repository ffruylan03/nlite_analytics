using Carter;
using MediatR;
using NLITE.ETL.API.Infrastructure.Persistence;

namespace NLITE.ETL.API.Features.GameMatrics;

public class CreateSeed : ICarterModule
{
    public void AddRoutes(IEndpointRouteBuilder app)
    {
        app.MapPost("api/gamemetrics/seed", async (HttpRequest req, IMediator mediator) =>
        {
            return await mediator.Send(new CreateCommand());
        })
        .ProducesProblem(StatusCodes.Status400BadRequest)
        .Produces(StatusCodes.Status201Created);
    }

    public class CreateCommand : IRequest<IResult> { }
    public class CreateHandler : IRequestHandler<CreateCommand, IResult>
    {
        private readonly ApiDbContext context;
        public CreateHandler(ApiDbContext context)
        {
            this.context = context;
        }

        public async Task<IResult> Handle(CreateCommand request, CancellationToken cancellationToken)
        {
            if (!context.Categories.Any())
            {
                var seed = new CategoryCsvMapping();
                context.Categories.AddRange(
                    seed.GetEntityData());

                await context.SaveChangesAsync(cancellationToken);
            }
            return Results.Ok();
        }
    }
}