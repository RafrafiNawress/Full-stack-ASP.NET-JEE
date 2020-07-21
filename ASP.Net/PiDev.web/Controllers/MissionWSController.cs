
using PiDev.Domain.Entity;
using PiDev.Service;
using PiDev.web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace PiDev.web.Controllers
{
    public class MissionWSController : Controller
    {
        private BillService cs = new BillService();


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
        /*
                [HttpPost, ActionName("Create")]
                public ActionResult Create(BillModel p , int idMission)
                {
                    HttpClient client = new HttpClient();
                    client.BaseAddress = new Uri("http://localhost:9080/pidev-web/");

                    // TODO: Add insert logic here
                    client.PostAsJsonAsync<BillModel>("api/Requestmission/17", p)
                            .ContinueWith((postTask) => postTask.Result.ReasonPhrase.Equals("Created"));

                    var tuple = new Tuple<mission, BillModel>(new mission(), p);
                    //return RedirectToAction("Index");
                    return View(tuple);
                }*/

        //  private BillModel resto, heb, trans;
        
        public ActionResult Create(int mission, int restau = 0,  int heb = 0, int trans = 0)
        {
            if (heb != 0)
            {
                bill hebergement = new bill()
                {
                    idMission = mission,
                    somme = heb,
                    matricule = "Hebergement"
                };
                cs.Add(hebergement);
            }
            if (restau != 0)
            {
                bill restauration = new bill()
                {
                    idMission = mission,
                    somme = restau,
                    matricule = "Restauration"
                };
                cs.Add(restauration);
            }
            if (trans != 0)
            {
                bill transport = new bill()
                {
                    idMission = mission,
                    somme = restau,
                    matricule = "Transport"
                };
                cs.Add(transport);
            }
            //resto.matricule = "Restauration";
            //resto.mission_id = 17;
            //resto.date= DateTime.Now;
            //heb.matricule = "Hebergement";
            //heb.mission_id = 17;
            //heb.date = DateTime.Now;
            //trans.matricule = "Transport";
            //trans.mission_id = 17;
            //trans.date = DateTime.Now;
            /* resto.setMission(missionService.getMissionById(idmission));
             resto.setDate(new Date());
             heb.setMatricule("Hebergement");
             heb.setMission(missionService.getMissionById(idmission));
             heb.setDate(new Date());
             trans.setMatricule("Transport");
             trans.setMission(missionService.getMissionById(idmission));
             trans.setDate(new Date());
             cs.addBill(resto.getSomme() == 0 ? null : resto, heb.getSomme() == 0 ? null : heb, trans.getSomme() == 0 ? null : trans);
     */
            //if (resto.somme==0)
            //cs.Add(resto);
            //if (heb.somme != 0)
            //    cs.Add(heb);
            //if (trans.somme != 0)
            //    cs.Add(trans);
            cs.Commit();
            //return RedirectToAction("Index");
            var tuple = new Tuple<mission, BillModel>(new mission(), new BillModel());
            return RedirectToAction("Index");
          // return View(tuple);
        }
    }
}