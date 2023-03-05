using Carter;
using MediatR;
using NLITE.ETL.API.Infrastructure.Persistence;
using NLITE.ETL.API.Infrastructure.Seeders;

namespace NLITE.ETL.API.Features.DbConfigurations;

public class SeeedGameMetric : ICarterModule
{
    public void AddRoutes(IEndpointRouteBuilder app)
    {
        app.MapPost("api/configurations/seeder/gamemetrics", async (HttpRequest req, IMediator mediator) =>
        {
            return await mediator.Send(new CreateCommand());
        })
        .ProducesProblem(StatusCodes.Status400BadRequest)
        .Produces(StatusCodes.Status200OK);
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
            if (!context.Categories.Any() && !context.GameMatrics.Any())
            {
                // Catgeories
                var categories_mapping = new CategorySeeder();
                var categories = categories_mapping.GetEntityData();
                context.Categories.AddRange(categories);
                await context.SaveChangesAsync(cancellationToken);

                // Game Metrics
                var gamemetrics_mapping = new GameMetricSeeder();
                var categories_db = context.Categories.ToList();
                var gamemetrics = gamemetrics_mapping.GetEntityData(categories_db);
                context.GameMatrics.AddRange(gamemetrics);
                await context.SaveChangesAsync(cancellationToken);

                return Results.Ok("Successfully seeded!");
            }

            return Results.Ok("Data already exist!");
        }
    }
}