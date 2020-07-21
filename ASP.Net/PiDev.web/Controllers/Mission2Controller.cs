using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using PiDev.Service;
using PiDev.Data;
using System.Net.Http;
using PiDev.web.Models;

namespace PiDev.web.Controllers
{
    public class Mission2Controller : Controller
    {
        private MissionService cs = new MissionService();
        private Context db = new Context();

        //GET: Mission Project
        public ActionResult MissionByProject()
        {
            //var mission = db.bills.FirstOrDefault();


            return View(cs.GetMany().ToList());
        }


        // GET: Bill/Create
        public ActionResult CreateBill(BillModel b)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9080/pidev-web/");

            // TODO: Add insert logic here
            client.PostAsJsonAsync<BillModel>("api/Requestmission", b)
                    .ContinueWith((postTask) => postTask.Result.ReasonPhrase.Equals("Created"));
            return RedirectToAction("Index");
        }
    }
}