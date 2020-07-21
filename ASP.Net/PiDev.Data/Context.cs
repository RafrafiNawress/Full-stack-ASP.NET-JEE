namespace PiDev.Data
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;
    using PiDev.Domain.Entity;

    public partial class Context : DbContext
    {
        public Context()
            : base("name=Context1")
        {
        }

        public virtual DbSet<bill> bills { get; set; }
        public virtual DbSet<commentaire> commentaires { get; set; }
        public virtual DbSet<competency> competencies { get; set; }
        public virtual DbSet<criterion> criteria { get; set; }
        public virtual DbSet<employee> employees { get; set; }
        public virtual DbSet<employeecompentency> employeecompentencies { get; set; }
        public virtual DbSet<evaluationsheet> evaluationsheets { get; set; }
        public virtual DbSet<followedup> followedups { get; set; }
        public virtual DbSet<formationcomment> formationcomments { get; set; }
        public virtual DbSet<holiday> holidays { get; set; }
        public virtual DbSet<job> jobs { get; set; }
        public virtual DbSet<jobcompetency> jobcompetencies { get; set; }
        public virtual DbSet<jobfamily> jobfamilies { get; set; }
        public virtual DbSet<mission> missions { get; set; }
        public virtual DbSet<missionrequest> missionrequests { get; set; }
        public virtual DbSet<notification> notifications { get; set; }
        public virtual DbSet<plan> plans { get; set; }
        public virtual DbSet<project> projects { get; set; }
        public virtual DbSet<reclamation> reclamations { get; set; }
        public virtual DbSet<request> requests { get; set; }
        public virtual DbSet<task> tasks { get; set; }
        public virtual DbSet<team> teams { get; set; }
        public virtual DbSet<training> trainings { get; set; }
        public virtual DbSet<trainingcentre> trainingcentres { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<bill>()
                .Property(e => e.image)
                .IsUnicode(false);

            modelBuilder.Entity<bill>()
                .Property(e => e.matricule)
                .IsUnicode(false);

            modelBuilder.Entity<competency>()
                .Property(e => e.description)
                .IsUnicode(false);

            modelBuilder.Entity<competency>()
                .Property(e => e.name)
                .IsUnicode(false);

            modelBuilder.Entity<competency>()
                .HasMany(e => e.employees)
                .WithMany(e => e.competencies)
                .Map(m => m.ToTable("competency_employee", "pidev").MapLeftKey("competencies_id").MapRightKey("employees_id"));

            modelBuilder.Entity<criterion>()
                .Property(e => e.description)
                .IsUnicode(false);

            modelBuilder.Entity<employee>()
                .Property(e => e.email)
                .IsUnicode(false);

            modelBuilder.Entity<employee>()
                .Property(e => e.firstname)
                .IsUnicode(false);

            modelBuilder.Entity<employee>()
                .Property(e => e.lastname)
                .IsUnicode(false);

            modelBuilder.Entity<employee>()
                .Property(e => e.password)
                .IsUnicode(false);

            modelBuilder.Entity<employee>()
                .Property(e => e.photo)
                .IsUnicode(false);

            modelBuilder.Entity<employee>()
                .Property(e => e.role)
                .IsUnicode(false);

            modelBuilder.Entity<employee>()
                .HasMany(e => e.missionrequests)
                .WithOptional(e => e.employee)
                .HasForeignKey(e => e.employee_id);

            modelBuilder.Entity<employee>()
                .HasMany(e => e.tasks)
                .WithOptional(e => e.employee)
                .HasForeignKey(e => e.employee_id);

            modelBuilder.Entity<employee>()
                .HasMany(e => e.plans)
                .WithOptional(e => e.employee)
                .HasForeignKey(e => e.id_User);

            modelBuilder.Entity<employee>()
                .HasMany(e => e.projects)
                .WithMany(e => e.employees)
                .Map(m => m.ToTable("employee_project", "pidev").MapLeftKey("employees_id"));

            modelBuilder.Entity<employee>()
                .HasMany(e => e.teams)
                .WithMany(e => e.employees)
                .Map(m => m.ToTable("team_employee", "pidev").MapLeftKey("Employees_id").MapRightKey("Teams_id"));

            modelBuilder.Entity<evaluationsheet>()
                .Property(e => e.typeevaluation)
                .IsUnicode(false);

            modelBuilder.Entity<evaluationsheet>()
                .HasMany(e => e.criteria)
                .WithOptional(e => e.evaluationsheet)
                .HasForeignKey(e => e.idEvaluationSheet);

            modelBuilder.Entity<evaluationsheet>()
                .HasMany(e => e.employees)
                .WithOptional(e => e.evaluationsheet)
                .HasForeignKey(e => e.evaluationsheet_id);

            modelBuilder.Entity<formationcomment>()
                .Property(e => e.contenu)
                .IsUnicode(false);

            modelBuilder.Entity<formationcomment>()
                .HasMany(e => e.trainings)
                .WithOptional(e => e.formationcomment)
                .HasForeignKey(e => e.commentaire_id_comment);

            modelBuilder.Entity<job>()
                .Property(e => e.description)
                .IsUnicode(false);

            modelBuilder.Entity<job>()
                .Property(e => e.name)
                .IsUnicode(false);

            modelBuilder.Entity<job>()
                .HasMany(e => e.employees)
                .WithOptional(e => e.job)
                .HasForeignKey(e => e.job_id);

            modelBuilder.Entity<job>()
                .HasMany(e => e.competencies)
                .WithMany(e => e.jobs)
                .Map(m => m.ToTable("competency_job", "pidev").MapLeftKey("jobs_id").MapRightKey("competencies_id"));

            modelBuilder.Entity<jobfamily>()
                .Property(e => e.description)
                .IsUnicode(false);

            modelBuilder.Entity<jobfamily>()
                .Property(e => e.name)
                .IsUnicode(false);

            modelBuilder.Entity<jobfamily>()
                .HasMany(e => e.jobs)
                .WithOptional(e => e.jobfamily)
                .HasForeignKey(e => e.jobfamily_id);

            modelBuilder.Entity<mission>()
                .Property(e => e.DateF)
                .IsUnicode(false);

            modelBuilder.Entity<mission>()
                .Property(e => e.dateD)
                .IsUnicode(false);

            modelBuilder.Entity<mission>()
                .Property(e => e.location)
                .IsUnicode(false);

            modelBuilder.Entity<mission>()
                .Property(e => e.title)
                .IsUnicode(false);

            modelBuilder.Entity<mission>()
                .Property(e => e.type)
                .IsUnicode(false);

            modelBuilder.Entity<mission>()
                .HasMany(e => e.bills)
                .WithOptional(e => e.mission)
                .HasForeignKey(e => e.idMission);

            modelBuilder.Entity<mission>()
                .HasMany(e => e.missionrequests)
                .WithOptional(e => e.mission)
                .HasForeignKey(e => e.mission_id);

            modelBuilder.Entity<mission>()
                .HasMany(e => e.employees)
                .WithMany(e => e.missions)
                .Map(m => m.ToTable("employee_mission", "pidev").MapLeftKey("missions_id").MapRightKey("employes_id"));

            modelBuilder.Entity<missionrequest>()
                .Property(e => e.description)
                .IsUnicode(false);

            modelBuilder.Entity<missionrequest>()
                .HasMany(e => e.employees)
                .WithOptional(e => e.missionrequest)
                .HasForeignKey(e => e.missionRequest_id);

            modelBuilder.Entity<project>()
                .Property(e => e.description)
                .IsUnicode(false);

            modelBuilder.Entity<project>()
                .Property(e => e.endDate)
                .IsUnicode(false);

            modelBuilder.Entity<project>()
                .Property(e => e.startDate)
                .IsUnicode(false);

            modelBuilder.Entity<project>()
                .Property(e => e.title)
                .IsUnicode(false);

            modelBuilder.Entity<project>()
                .HasMany(e => e.missions)
                .WithOptional(e => e.project)
                .HasForeignKey(e => e.idProject);

            modelBuilder.Entity<project>()
                .HasMany(e => e.tasks)
                .WithOptional(e => e.project)
                .HasForeignKey(e => e.project_id);

            modelBuilder.Entity<task>()
                .Property(e => e.description)
                .IsUnicode(false);

            modelBuilder.Entity<task>()
                .Property(e => e.endDate)
                .IsUnicode(false);

            modelBuilder.Entity<task>()
                .Property(e => e.startDate)
                .IsUnicode(false);

            modelBuilder.Entity<task>()
                .Property(e => e.status)
                .IsUnicode(false);

            modelBuilder.Entity<task>()
                .Property(e => e.title)
                .IsUnicode(false);

            modelBuilder.Entity<training>()
                .Property(e => e.description)
                .IsUnicode(false);

            modelBuilder.Entity<training>()
                .Property(e => e.image)
                .IsUnicode(false);

            modelBuilder.Entity<training>()
                .Property(e => e.name)
                .IsUnicode(false);

            modelBuilder.Entity<training>()
                .HasMany(e => e.formationcomments)
                .WithOptional(e => e.training)
                .HasForeignKey(e => e.formation_id);

            modelBuilder.Entity<training>()
                .HasMany(e => e.plans)
                .WithOptional(e => e.training)
                .HasForeignKey(e => e.id_formation);

            modelBuilder.Entity<training>()
                .HasMany(e => e.employees)
                .WithMany(e => e.trainings)
                .Map(m => m.ToTable("training_employee", "pidev").MapLeftKey("Training_id").MapRightKey("formationEmp_id"));

            modelBuilder.Entity<trainingcentre>()
                .Property(e => e.adress)
                .IsUnicode(false);

            modelBuilder.Entity<trainingcentre>()
                .Property(e => e.libelle)
                .IsUnicode(false);

            modelBuilder.Entity<trainingcentre>()
                .HasMany(e => e.plans)
                .WithOptional(e => e.trainingcentre)
                .HasForeignKey(e => e.id_center);
        }
    }
}
