namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    //using System.Data.Entity.Spatial;

    [Table("pidev.training")]
    public partial class training
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public training()
        {
            formationcomments = new HashSet<formationcomment>();
            plans = new HashSet<plan>();
            employees = new HashSet<employee>();
        }

        public int id { get; set; }

        public int NumberMax { get; set; }

        [StringLength(255)]
        public string description { get; set; }

        public int duree { get; set; }

        [StringLength(255)]
        public string image { get; set; }

        [StringLength(255)]
        public string name { get; set; }

        [Column(TypeName = "bit")]
        public bool? status { get; set; }

        public int? commentaire_id_comment { get; set; }

        public virtual formationcomment formationcomment { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<formationcomment> formationcomments { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<plan> plans { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<employee> employees { get; set; }
    }
}
