namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    [Table("pidev.bill")]
    public partial class bill
    {
        public int id { get; set; }

        public DateTime? date { get; set; }

        [StringLength(255)]
        public string image { get; set; }

        [StringLength(255)]
        public string matricule { get; set; }

        public int somme { get; set; }

        public int? idMission { get; set; }

        public virtual mission mission { get; set; }
    }
}
