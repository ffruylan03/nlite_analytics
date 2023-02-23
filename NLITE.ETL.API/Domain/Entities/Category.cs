namespace NLITE.ETL.API.Domain.Entities;

public class Category : BaseEntity
{

    public Category(string code, string description)
    {
        Code = code;
        Description = description;
    }

    public string Code { get; private set; }
    public string Description { get; private set; }

    public ICollection<Matric> Matrics { get; set; } = new HashSet<Matric>();
}
