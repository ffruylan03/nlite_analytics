namespace NLITE.ETL.API.Domain.Entities;

public class Matric : BaseEntity
{
    public Matric(int categoryId, int minimum, int maximum, int value)
    {
        CategoryId = categoryId;
        Minimum = minimum;
        Maximum = maximum;
        Value = value;
    }

    public int CategoryId { get; private set; }
    public Category? Category { get; private set; }

    public int Minimum { get; private set; }
    public int Maximum { get; private set; }
    public int Value { get; private set; }

    public string? CategoryName => Category?.Description;
}
