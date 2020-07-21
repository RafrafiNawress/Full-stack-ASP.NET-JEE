using PiDev.Domain.Entity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace PiDev.web.Models
{
    public class BillModel
    {

        public int id { get; set; }

        public DateTime? date { get; set; }

        [StringLength(255)]
        public string image { get; set; }

        [StringLength(255)]
        public string matricule { get; set; }

        public int? mission_id { get; set; }

        public int? idBill { get; set; }

        public int? idMission { get; set; }

        public int somme { get; set; }

        public bill heb { get; set; }
        public bill trans { get; set; }
        public bill restau { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<mission> missions { get; set; }

        public virtual mission mission { get; set; }

        public virtual mission mission1 { get; set; }

        public virtual mission mission2 { get; set; }
    }
}