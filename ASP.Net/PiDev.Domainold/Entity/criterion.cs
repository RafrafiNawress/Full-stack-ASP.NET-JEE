namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    //using System.Data.Entity.Spatial;

    [Table("pidev.criteria")]
    public partial class criterion
    {
        public int id { get; set; }

        public int Note { get; set; }

        [StringLength(255)]
        public string description { get; set; }

        public int? idEvaluationSheet { get; set; }

        public virtual evaluationsheet evaluationsheet { get; set; }
    }
}
