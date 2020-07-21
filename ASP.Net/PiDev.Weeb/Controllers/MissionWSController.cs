using PiDev.Domain.Entity;
using PiDev.Service;
using PiDev.weeb.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;


namespace PiDev.weeb.Controllers
{
    public class MissionWSController : Controller
    {
        private BillService cs = new BillService();

        private MissionService ms = new MissionService();

        public ActionResult Index()
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/pidev-web/");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("Application/json"));
            HttpResponseMessage response = Client.GetAsync("api/mission").Result;
            if (response.IsSuccessStatusCode)
            {
                IEnumerable<mission> missions = response.Content.ReadAsAsync<IEnumerable<mission>>().Result;
                ViewBag.Result = missions;
            }
            else
            {
                ViewBag.Result = "error";
            }
            Console.WriteLine("ViewBag.Result  : " + ViewBag.Result);

            return View();
        }


        // GET: Mission/Delete/5
        public ActionResult Delete(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9080/pidev-web/");
            client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = client.GetAsync("api/mission/" + id).Result;
            mission mission = new mission();
            if (response.IsSuccessStatusCode)
            {

                mission = response.Content.ReadAsAsync<mission>().Result;

            }
            else
            {
                ViewBag.mission = "erreur";
            }

           return View(mission);
        }

        // POST: Mission/Delete/5
        [HttpPost, ActionName("Delete")]
        public ActionResult DeleteConfirmation(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
                HttpClient client = new HttpClient();
                client.BaseAddress = new Uri("http://localhost:9080/pidev-web/");

                // TODO: Add insert logic here
                client.DeleteAsync("api/mission/" + id)
                        .ContinueWith((postTask) => postTask.Result.IsSuccessStatusCode);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }



        public ActionResult Create(int mission, int restau = 0,  int heb = 0, int trans = 0)
        {
            if (heb != 0)
            {
                bill hebergement = new bill()
                {
                    idMission = mission,
                    somme = heb,
                    matricule = "Hebergement",
                    date = DateTime.Now
                };
                cs.Add(hebergement);
            }
            if (restau != 0)
            {
                bill restauration = new bill()
                {
                    idMission = mission,
                    somme = restau,
                    matricule = "Restauration",
                    date = DateTime.Now
                };
                cs.Add(restauration);
            }
            if (trans != 0)
            {
                bill transport = new bill()
                {
                    idMission = mission,
                    somme = trans,
                    matricule = "Transport",
                    date = DateTime.Now
                };
                cs.Add(transport);
            }
            cs.Commit();
            var tuple = new Tuple<mission, BillModel>(new mission(), new BillModel());
            return RedirectToAction("Index");
        }



        // GET: Claims/Details/5
        public ActionResult DetailsBill(int id)
        {
            if (id == 0)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            mission miss = ms.GetById((id));

           IEnumerable <bill> b = cs.GetBillsByIdMission(id);
            if (b == null)
            {
                ViewBag.nombre = "0";
            }
            else
            {
                ViewBag.Result = b;

            }

            if (miss == null)
            {
                return HttpNotFound();
            }
            return View(b);
        }


    }
}