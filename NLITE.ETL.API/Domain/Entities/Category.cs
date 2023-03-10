using Ardalis.GuardClauses;

namespace NLITE.ETL.API.Domain.Entities;

public class Category : BaseEntity
{

    public Category(string code, string description)
    {
        Guard.Against.NullOrWhiteSpace(code);
        Guard.Against.NullOrWhiteSpace(description);

        Code = code;
        Description = description;
    }

    public string Code { get; private set; }
    public string Description { get; private set; }

    public ICollection<GameMetric> Matrics { get; set; } = new HashSet<GameMetric>();
}
