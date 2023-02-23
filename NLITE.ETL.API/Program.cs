
using Carter;
using FluentValidation;
using NLITE.ETL.API.Extensions;
using NLITE.ETL.API.Helpers;
using System.Reflection;

var builder = WebApplication.CreateBuilder(args);
builder.Host.AddSerilog();

// ConfigureServices
builder.Services.AddCustomCors();
builder.Services.AddPersistence(builder.Configuration);
builder.Services.AddSwagger();
builder.Services.AddCarter();
builder.Services.AddAutoMapper(Assembly.GetExecutingAssembly());
builder.Services.AddMediator();
builder.Services.AddValidatorsFromAssemblyContaining(typeof(Program));


var app = builder.Build();

// Configure
app.UseCors(AppConstants.CorsPolicy);
app.UseStaticFiles();
app.MapSwagger();
app.MapCarter();

app.Run();