namespace NLITE.ETL.API.Domain.Entities;

public class BaseEntity
{

    public BaseEntity()
    {
        Id = Guid.NewGuid();
        Created = DateTime.UtcNow;
    }

    public Guid Id { get; set; }
    public DateTime Created { get; set; }
}
