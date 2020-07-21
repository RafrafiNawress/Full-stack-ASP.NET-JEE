namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    //using System.Data.Entity.Spatial;

    [Table("pidev.job")]
    public partial class job
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public job()
        {
            employees = new HashSet<employee>();
            competencies = new HashSet<competency>();
        }

        public int id { get; set; }

        [StringLength(255)]
        public string description { get; set; }

        public int level { get; set; }

        [StringLength(255)]
        public string name { get; set; }

        public int? jobfamily_id { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<employee> employees { get; set; }

        public virtual jobfamily jobfamily { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<competency> competencies { get; set; }
    }
}
