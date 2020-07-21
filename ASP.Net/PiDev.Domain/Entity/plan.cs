namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    //using System.Data.Entity.Spatial;

    [Table("pidev.plan")]
    public partial class plan
    {
        [Key]
        public int id_planing { get; set; }

        public DateTime? date_formation { get; set; }

        public int? id_center { get; set; }

        public int? id_formation { get; set; }

        public int? id_User { get; set; }

        public virtual employee employee { get; set; }

        public virtual training training { get; set; }

        public virtual trainingcentre trainingcentre { get; set; }
    }
}
