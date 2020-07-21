using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(PiDev.web.Startup))]
namespace PiDev.web
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
