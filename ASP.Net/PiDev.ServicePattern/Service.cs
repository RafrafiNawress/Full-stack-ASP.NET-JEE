using PiDev.Data.Infrastructure;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace PiDev.ServicePattern
{
    public abstract class Service<TEntity> : IService<TEntity> where TEntity : class
    {

        IUnitOfWork utwk;
        private IUnitOfWork utwk1;
        private IUnitOfWork ut;

        protected Service(IUnitOfWork utwk)
        {
            this.utwk = utwk;
        }

        public Service()
        {
        }



        public virtual void Add(TEntity entity)
        {
            ////_repository.Add(entity);
            utwk.getRepository<TEntity>().Add(entity);

        }

        public virtual void Update(int id, TEntity entity)
        {
            //_repository.Update(entity);
            utwk.getRepository<TEntity>().Update(id, entity);
        }

        public virtual void Delete(TEntity entity)
        {
            //   _repository.Delete(entity);
            utwk.getRepository<TEntity>().Delete(entity);
        }

        public virtual void Delete(Expression<Func<TEntity, bool>> where)
        {
            // _repository.Delete(where);
            utwk.getRepository<TEntity>().Delete(where);
        }

        public virtual TEntity GetById(long id)
        {
            //  return _repository.GetById(id);
            return utwk.getRepository<TEntity>().GetById(id);
        }

        public virtual IEnumerable<TEntity> GetAll()
        {
            return utwk.getRepository<TEntity>().GetAll();
            //return _repository.GetById(id);
            //  return utwk.getRepository<TEntity>().GetById(id);
        }

        public virtual IEnumerable<TEntity> GetMany(Expression<Func<TEntity, bool>> filter = null, Expression<Func<TEntity, bool>> orderBy = null)
        {
            //  return _repository.GetAll();
            return utwk.getRepository<TEntity>().GetMany(filter, orderBy);
        }

        public virtual TEntity Get(Expression<Func<TEntity, bool>> where)
        {
            //return _repository.Get(where);
            return utwk.getRepository<TEntity>().Get(where);
        }

        public virtual List<TEntity> GetInclude(Expression<Func<TEntity, bool>> filter = null, Func<IQueryable<TEntity>, IOrderedQueryable<TEntity>> orderBy = null, params Expression<Func<TEntity, object>>[] includes)
        {
            return utwk.getRepository<TEntity>().GetInclude(filter, orderBy, includes);
        }

        public void Commit()
        {

            utwk.Commit();


        }


        public void Dispose()
        {
            utwk.Dispose();
       }
    }

}
