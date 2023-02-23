using Serilog.Events;
using Serilog;

namespace NLITE.ETL.API.Extensions;

public static class WebApplicationBuilderExtensions
{
    public static void AddSerilog(this ConfigureHostBuilder host)
    {
        host.UseSerilog();

        Log.Logger = new LoggerConfiguration()
            .MinimumLevel.Override("Microsoft", LogEventLevel.Information)
            .Enrich.FromLogContext()
            .WriteTo.Console()
            .CreateLogger();
    }
}
