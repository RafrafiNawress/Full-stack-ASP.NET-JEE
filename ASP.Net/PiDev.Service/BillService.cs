using PiDev.Domain.Entity;
using PiDev.ServicePattern;
using PiDev.Data.Infrastructure;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PiDev.Service
{
    public class BillService : Service<bill>, IBillService
    {
        private static IDatabaseFactory dbf = new DatabaseFactory();
        private static IUnitOfWork ut = new UnitOfWork(dbf);
        public BillService() : base(ut)
        {


        }

        public IEnumerable<bill> GetBillsByIdMission(int MissionId)
        {
            return GetMany(c => c.idMission==(MissionId));
        }
    }
}
