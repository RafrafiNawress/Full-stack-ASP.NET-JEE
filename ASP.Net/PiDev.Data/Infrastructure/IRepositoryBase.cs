using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace PiDev.Data.Infrastructure
{
    public interface IRepositoryBase<T>
     where T : class
    {
        void Add(T entity);
        void Delete(Expression<Func<T, bool>> where);
        void Delete(T entity);
        T Get(Expression<Func<T, bool>> where);

        T GetById(long id);
        T GetById(string id);
        IEnumerable<T> GetMany(Expression<Func<T, bool>> where = null, Expression<Func<T, bool>> orderBy = null);

        void Update(int id, T entity);
        IEnumerable<T> GetAll();
         List<T> GetInclude(Expression<Func<T, bool>> filter = null, Func<IQueryable<T>, IOrderedQueryable<T>> orderBy = null, params Expression<Func<T, object>>[] includes);



    }
}
