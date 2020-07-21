namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    //using System.Data.Entity.Spatial;

    [Table("pidev.formationcomment")]
    public partial class formationcomment
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public formationcomment()
        {
            trainings = new HashSet<training>();
        }

        [Key]
        public int id_comment { get; set; }

        [StringLength(255)]
        public string contenu { get; set; }

        public int? formation_id { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<training> trainings { get; set; }

        public virtual training training { get; set; }
    }
}
