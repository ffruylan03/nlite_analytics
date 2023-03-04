using MediatR;
using Microsoft.EntityFrameworkCore;
using NLITE.ETL.API.Common.Behaviours;
using NLITE.ETL.API.Helpers;
using NLITE.ETL.API.Infrastructure.Persistence;
using System.Reflection;

namespace NLITE.ETL.API.Extensions;

public static class ServiceCollectionExtensions
{
    public static IServiceCollection AddSwagger(this IServiceCollection services)
    {
        services.AddEndpointsApiExplorer();
        services.AddOpenApiDocument(c =>
        {
            c.Title = "NLITE Analytics";
            c.Version = "v1";
        });

        return services;
    }

    public static IServiceCollection AddCustomCors(this IServiceCollection services)
    {
        services.AddCors(options =>
        {
            options.AddPolicy(name: AppConstants.CorsPolicy, builder =>
            {
                builder.AllowAnyOrigin().AllowAnyMethod().AllowAnyHeader();
            });
        });

        return services;
    }

    public static IServiceCollection AddPersistence(this IServiceCollection services, IConfiguration config)
    {
        services.AddDbContext<ApiDbContext>(c => c.UseSqlServer(config.GetConnectionString("Default")));

        return services;
    }

    public static IServiceCollection AddMediator(this IServiceCollection services)
    {
        services.AddMediatR(cfg => cfg.RegisterServicesFromAssembly(Assembly.GetExecutingAssembly()));
        services.AddTransient(typeof(IPipelineBehavior<,>), typeof(TransactionBehaviour<,>));

        return services;
    }
}
