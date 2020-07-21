using System.Web;
using System.Web.Optimization;

namespace PiDev.Weeb
{
    public class BundleConfig
    {
        // For more information on bundling, visit http://go.microsoft.com/fwlink/?LinkId=301862
        public static void RegisterBundles(BundleCollection bundles)
        {
            bundles.Add(new ScriptBundle("~/bundles/jquery").Include(
                        "~/Scripts/jquery-{version}.js"));

            bundles.Add(new ScriptBundle("~/bundles/jqueryval").Include(
                        "~/Scripts/jquery.validate*"));

            // Use the development version of Modernizr to develop with and learn from. Then, when you're
            // ready for production, use the build tool at http://modernizr.com to pick only the tests you need.
            bundles.Add(new ScriptBundle("~/bundles/modernizr").Include(
                        "~/Scripts/modernizr-*"));

            bundles.Add(new ScriptBundle("~/bundles/bootstrap").Include(
                      "~/Scripts/bootstrap.js",
                      "~/Scripts/respond.js"));

            bundles.Add(new StyleBundle("~/Content/css").Include(
                      "~/Content/bootstrap.css",
                      "~/Content/site.css"));


            #region Template
            bundles.Add(new ScriptBundle("~/template/js").Include(
                    "~/Content/js/fbevents.js",
                    "~/Content/js/jquery.min.js",
                    "~/Content/js/popper.min.js",
                    "~/Content/js/bootstrap-material-design.min.js",
                     "~/Content/js/perfect-scrollbar.jquery.min.js",
                      "~/Content/js/moment.min.js",

                      "~/Content/js/jquery.validate.min.js",
                    "~/Content/js/jquery.bootstrap-wizard.js",
                    "~/Content/js/bootstrap-selectpicker.js",
                    "~/Content/js/bootstrap-datetimepicker.min.js",
                     "~/Content/js/jquery.dataTables.min.js",
                      "~/Content/js/bootstrap-tagsinput.js",
                       "~/Content/js/jasny-bootstrap.min.js",

                        "~/Content/js/fullcalendar.min.js",
                     "~/Content/js/jquery-jvectormap.js",
                      "~/Content/js/nouislider.min.js",
                       "~/Content/js/arrive.min.js",

                         "~/Content/js/core.js",
                     "~/Content/js/buttons.js",
                      "~/Content/js/chartist.min.js",
                       "~/Content/js/bootstrap-notify.js",
                    "~/Content/js/material-dashboard.minf066.js"));

            bundles.Add(new StyleBundle("~/template/css").Include(
                      "~/Content/css/font-awesome.min.css",
                      "~/Content/css/material-dashboard.minf066.css"

                      ));
            #endregion
        }


    }
}
