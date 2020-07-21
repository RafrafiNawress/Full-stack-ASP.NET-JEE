using PiDev.Data.Infrastructure;
using PiDev.Domain.Entity;
using PiDev.ServicePattern;
using System.Collections.Generic;

namespace PiDev.Service
{
   public class MissionService : Service<mission>, IMissionService
    {
        private static IDatabaseFactory dbf = new DatabaseFactory();
        private static IUnitOfWork ut = new UnitOfWork(dbf);
        public MissionService() : base(ut)
        {


        }

     

        public IEnumerable<mission> GetMissionByIdProject(int ProjectId)
        {
            return GetMany(c => c.idProject==(1));
        }
    }
}
