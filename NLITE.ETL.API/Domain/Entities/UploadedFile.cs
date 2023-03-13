using Ardalis.GuardClauses;

namespace NLITE.ETL.API.Domain.Entities
{
    public class UploadedFile : BaseEntity
    {
        public UploadedFile(string filename, string status)
        {
            Guard.Against.NullOrWhiteSpace(filename);
            Guard.Against.NullOrWhiteSpace(status);

            FileName = filename;
            Status = status;
        }

        public string FileName { get; private set; }
        public string Status { get; private set; }
    }
}
