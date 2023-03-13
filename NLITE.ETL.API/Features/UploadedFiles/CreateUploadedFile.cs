using Carter;
using MediatR;
using NLITE.ETL.API.Domain.Entities;
using NLITE.ETL.API.Infrastructure.Persistence;

namespace NLITE.ETL.API.Features.UploadedFiles;

public class CreateUploadedFile : ICarterModule
{
    public void AddRoutes(IEndpointRouteBuilder app)
    {
        app.MapPost("api/uploadedfile", async (IMediator mediator, CreateCommand command) =>
        {
            return await mediator.Send(command);
        })
        .ProducesProblem(StatusCodes.Status400BadRequest)
        .Produces(StatusCodes.Status200OK);
    }

    public class CreateCommand : IRequest<IResult> 
    {
        public string FileName { get; set; } = string.Empty;
        public string Status { get; set; } = "Uploaded";
    }
    public class CreateHandler : IRequestHandler<CreateCommand, IResult>
    {
        private readonly ApiDbContext context;
        public CreateHandler(ApiDbContext context)
        {
            this.context = context;
        }

        public async Task<IResult> Handle(CreateCommand request, CancellationToken cancellationToken)
        {
            UploadedFile uploadedfile;
            IResult result;
            try
            {
                uploadedfile = new UploadedFile(request.FileName, request.Status);
                await context.UploadedFiles.AddAsync(uploadedfile, cancellationToken);
                await context.SaveChangesAsync(cancellationToken);

                result = Results.Ok(uploadedfile.Id);
            }
            catch (Exception ex)
            {
                result = Results.Problem(ex.Message);
            }

            return result;
        }
    }
}
