using System.Net;

namespace NLITE.ETL.API.Helpers;

public static class CsvHelper
{
    public static string GetCSVFromUrl(string url)
    {
        using var client = new HttpClient();
        HttpResponseMessage response = client.GetAsync(url).Result;
        Stream stream = response.Content.ReadAsStreamAsync().Result;
        using StreamReader reader = new(stream);
        string? results = reader.ReadToEndAsync().Result;
        return results;
    }
}
