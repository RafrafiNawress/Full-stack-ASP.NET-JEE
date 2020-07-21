using PiDev.Domain.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace PiDev.Weeb.Controllers
{
    public class MissionRequestController : Controller
    {
        // GET: MissionRequest

        public ActionResult Index()
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/pidev-web/");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("Application/json"));
            HttpResponseMessage response = Client.GetAsync("api/Requestmission").Result;
            if (response.IsSuccessStatusCode)
            {
                IEnumerable<missionrequest> missions = response.Content.ReadAsAsync<IEnumerable<missionrequest>>().Result;
                ViewBag.Result = missions;
            }
            else
            {
                ViewBag.Result = "error";
            }
            Console.WriteLine("ViewBag.Result  : " + ViewBag.Result);

            return View();
        }
    }
}