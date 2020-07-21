namespace PiDev.Domain.Entity
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    //using System.Data.Entity.Spatial;

    [Table("pidev.task")]
    public partial class task
    {
        public int id { get; set; }

        [StringLength(255)]
        public string description { get; set; }

        [StringLength(255)]
        public string endDate { get; set; }

        [StringLength(255)]
        public string startDate { get; set; }

        [StringLength(255)]
        public string status { get; set; }

        [StringLength(255)]
        public string title { get; set; }

        public int? employee_id { get; set; }

        public int? project_id { get; set; }

        public virtual employee employee { get; set; }

        public virtual project project { get; set; }
    }
}
