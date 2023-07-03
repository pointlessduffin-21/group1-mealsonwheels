import React, { Component } from 'react';

class Home extends Component{

    render(){
        return(
            <div>
  <meta charSet="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
  <title>Home - Brand</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&display=swap" />
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic&display=swap" />
  <link rel="stylesheet" href="assets/fonts/font-awesome.min.css" />
  <link rel="stylesheet" href="assets/css/aos.min.css" />
  <link rel="stylesheet" href="assets/css/baguetteBox.min.css" />
  <nav className="navbar navbar-light navbar-expand-lg fixed-top" id="mainNav">
    <div className="container"><a className="navbar-brand" href="#page-top">Brand</a><button data-bs-toggle="collapse" data-bs-target="#navbarResponsive" className="navbar-toggler navbar-toggler-right" type="button" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i className="fa fa-align-justify" /></button>
      <div className="collapse navbar-collapse" id="navbarResponsive">
        <ul className="navbar-nav ms-auto">
          <li className="nav-item"><a className="nav-link" href="#about">About</a></li>
          <li className="nav-item"><a className="nav-link" href="#services">Services</a></li>
          <li className="nav-item"><a className="nav-link" href="#portfolio">Portfolio</a></li>
          <li className="nav-item"><a className="nav-link" href="#contact">Contact</a></li>
        </ul>
      </div>
    </div>
  </nav>
  <header className="text-center text-white d-flex masthead" style={{backgroundImage: 'url("assets/img/header.jpg")'}}>
    <div className="container my-auto">
      <div className="row">
        <div className="col-lg-10 mx-auto">
          <h1 className="text-uppercase"><strong>Your Favorite Source of Free Bootstrap Themes</strong></h1>
          <hr />
        </div>
      </div>
      <div className="col-lg-8 mx-auto">
        <p className="text-faded mb-5">We can help you build better websites using the Bootstrap CSS framework! Just download your template and start going, no strings attached!</p><a className="btn btn-primary btn-xl" role="button" href="#services">Find Out More</a>
      </div>
    </div>
  </header>
  <section id="about" className="bg-primary">
    <div className="container">
      <div className="row">
        <div className="col offset-lg-8 text-center mx-auto">
          <h2 className="text-white section-heading">We've got what you need!</h2>
          <hr className="light my-4" />
          <p className="text-faded mb-4">Bootstrap has everything you need to get your new website up and running in no time! All of the templates and themes are open source, free to download, and easy to use. No strings attached!</p><a className="btn btn-light btn-xl" role="button" href="#services">Get Started!</a>
        </div>
      </div>
    </div>
  </section>
  <section id="services">
    <div className="container">
      <div className="row">
        <div className="col-lg-12 text-center">
          <h2 className="section-heading">At Your Service</h2>
          <hr className="my-4" />
        </div>
      </div>
    </div>
    <div className="container">
      <div className="row">
        <div className="col-md-6 col-lg-3 text-center">
          <div className="mx-auto service-box mt-5"><i className="fa fa-diamond fa-4x text-primary mb-3 sr-icons" data-aos="zoom-in" data-aos-duration={200} data-aos-once="true" />
            <h3 className="mb-3">Sturdy Templates</h3>
            <p className="text-muted mb-0">Our templates are updated regularly so they don't break.</p>
          </div>
        </div>
        <div className="col-md-6 col-lg-3 text-center">
          <div className="mx-auto service-box mt-5"><i className="fa fa-paper-plane fa-4x text-primary mb-3 sr-icons" data-aos="zoom-in" data-aos-duration={200} data-aos-delay={200} data-aos-once="true" />
            <h3 className="mb-3">Ready to Ship</h3>
            <p className="text-muted mb-0">You can use this theme as is, or you can make changes!</p>
          </div>
        </div>
        <div className="col-md-6 col-lg-3 text-center">
          <div className="mx-auto service-box mt-5"><i className="fa fa-newspaper-o fa-4x text-primary mb-3 sr-icons" data-aos="zoom-in" data-aos-duration={200} data-aos-delay={400} data-aos-once="true" />
            <h3 className="mb-3">Up to Date</h3>
            <p className="text-muted mb-0">We update dependencies to keep things fresh.</p>
          </div>
        </div>
        <div className="col-md-6 col-lg-3 text-center">
          <div className="mx-auto service-box mt-5"><i className="fa fa-heart fa-4x text-primary mb-3 sr-icons" data-aos="fade" data-aos-duration={200} data-aos-delay={600} data-aos-once="true" />
            <h3 className="mb-3">Made with Love</h3>
            <p className="text-muted mb-0">You have to make your websites with love these days!</p>
          </div>
        </div>
      </div>
    </div>
  </section>
  <section id="portfolio" className="p-0">
    <div className="container-fluid p-0">
      <div className="row g-0 popup-gallery">
        <div className="col-sm-6 col-lg-4"><a className="portfolio-box" href="assets/img/fullsize/1.jpg"><img className="img-fluid" src="assets/img/thumbnails/1.jpg" />
            <div className="portfolio-box-caption">
              <div className="portfolio-box-caption-content">
                <div className="project-category text-faded"><span>Category</span></div>
                <div className="project-name"><span>Project Name</span></div>
              </div>
            </div>
          </a></div>
        <div className="col-sm-6 col-lg-4"><a className="portfolio-box" href="assets/img/fullsize/2.jpg"><img className="img-fluid" src="assets/img/thumbnails/2.jpg" />
            <div className="portfolio-box-caption">
              <div className="portfolio-box-caption-content">
                <div className="project-category text-faded"><span>Category</span></div>
                <div className="project-name"><span>Project Name</span></div>
              </div>
            </div>
          </a></div>
        <div className="col-sm-6 col-lg-4"><a className="portfolio-box" href="assets/img/fullsize/3.jpg"><img className="img-fluid" src="assets/img/thumbnails/3.jpg" />
            <div className="portfolio-box-caption">
              <div className="portfolio-box-caption-content">
                <div className="project-category text-faded"><span>Category</span></div>
                <div className="project-name"><span>Project Name</span></div>
              </div>
            </div>
          </a></div>
        <div className="col-sm-6 col-lg-4"><a className="portfolio-box" href="assets/img/fullsize/4.jpg"><img className="img-fluid" src="assets/img/thumbnails/4.jpg" />
            <div className="portfolio-box-caption">
              <div className="portfolio-box-caption-content">
                <div className="project-category text-faded"><span>Category</span></div>
                <div className="project-name"><span>Project Name</span></div>
              </div>
            </div>
          </a></div>
        <div className="col-sm-6 col-lg-4"><a className="portfolio-box" href="assets/img/fullsize/5.jpg"><img className="img-fluid" src="assets/img/thumbnails/5.jpg" />
            <div className="portfolio-box-caption">
              <div className="portfolio-box-caption-content">
                <div className="project-category text-faded"><span>Category</span></div>
                <div className="project-name"><span>Project Name</span></div>
              </div>
            </div>
          </a></div>
        <div className="col-sm-6 col-lg-4"><a className="portfolio-box" href="assets/img/fullsize/6.jpg"><img className="img-fluid" src="assets/img/thumbnails/6.jpg" />
            <div className="portfolio-box-caption">
              <div className="portfolio-box-caption-content">
                <div className="project-category text-faded"><span>Category</span></div>
                <div className="project-name"><span>Project Name</span></div>
              </div>
            </div>
          </a></div>
      </div>
    </div>
  </section>
  <section className="text-white bg-dark">
    <div className="container text-center">
      <h2 className="mb-4">Lorem Ipsum!</h2><a className="btn btn-light btn-xl sr-button" role="button" data-aos="zoom-in" data-aos-duration={400} data-aos-once="true" href="#">Download Now!</a>
    </div>
  </section>
  <section id="contact">
    <div className="container">
      <div className="row">
        <div className="col-lg-8 text-center mx-auto">
          <h2 className="section-heading">Let's Get In Touch!</h2>
          <hr className="my-4" />
          <p className="mb-5">Ready to start your next project with us? That's great! Give us a call or send us an email and we will get back to you as soon as possible!</p>
        </div>
      </div>
      <div className="row">
        <div className="col-lg-4 text-center ms-auto"><i className="fa fa-phone fa-3x mb-3 sr-contact" data-aos="zoom-in" data-aos-duration={300} data-aos-once="true" />
          <p>123-456-6789</p>
        </div>
        <div className="col-lg-4 text-center me-auto"><i className="fa fa-envelope-o fa-3x mb-3 sr-contact" data-aos="zoom-in" data-aos-duration={300} data-aos-delay={300} data-aos-once="true" />
          <p><a href="mailto:your-email@your-domain.com">email@example.com</a></p>
        </div>
      </div>
    </div>
  </section>
</div>

        )
    }
}

export default Home;