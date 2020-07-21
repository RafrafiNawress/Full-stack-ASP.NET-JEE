namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    //using System.Data.Entity.Spatial;

    [Table("pidev.missionrequest")]
    public partial class missionrequest
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public missionrequest()
        {
            employees = new HashSet<employee>();
        }

        public int id { get; set; }

        public int affect { get; set; }

        [StringLength(255)]
        public string description { get; set; }

        public int? employee_id { get; set; }

        public int? mission_id { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<employee> employees { get; set; }

        public virtual employee employee { get; set; }

        public virtual mission mission { get; set; }
    }
}
