namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    //using System.Data.Entity.Spatial;

    [Table("pidev.trainingcentre")]
    public partial class trainingcentre
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public trainingcentre()
        {
            plans = new HashSet<plan>();
        }

        public int id { get; set; }

        [StringLength(255)]
        public string adress { get; set; }

        public int contact { get; set; }

        [Column(TypeName = "bit")]
        public bool? disponibilite { get; set; }

        [StringLength(255)]
        public string libelle { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<plan> plans { get; set; }
    }
}
