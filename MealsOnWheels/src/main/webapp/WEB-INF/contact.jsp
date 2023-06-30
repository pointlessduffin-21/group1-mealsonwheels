<!--
    Contact Us Page
    by BustinMeksmefilgud (Sebastian Seth Esacrro)
-->
<html>
<head>
  <title>Contact Us</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <style>  
    body{
        background-image: url("/pics/bg.jpg");
        background-size: cover;
        background-position: center;
        background-attachment: fixed;
        margin: 0;
        padding: 0;
    }

    .rounded-borders {
    background-color: #f5f5f5;
    border-radius: 10px;
    padding: 20px;
  }
</style>
</head>
<body>
  <div class="container">

    <h2 class="mt-5 text-danger">Contact Us</h2>
    <div class="row my-5 rounded-borders">
      <div class="col-md-6 my-auto">
        <h3 class="my-5"><i class="fas fa-phone-alt"></i> +53 713782432</h3>
        <h3 class="my-5"><i class="fas fa-envelope"></i> mealonyourmoo@gmail.com</h3>
        <h3 class="my-5"><i class="fas fa-map-marker-alt"></i> Your mom's house</h3>
      </div>
      <div class="col-md-6 text-center">
        <img src="/pics/chibifuuk.png" alt="fuuk" weight="300" height="300">
      </div>
    </div>
    

    <form class="mb-5 rounded-borders">
      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" class="form-control" id="name" name="name" required>
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" class="form-control" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="message">Message:</label>
        <textarea class="form-control" id="message" name="message" rows="5" required></textarea>
      </div>
      <button type="submit" class="btn btn-primary">Send Message</button>
    </form>
  </div>
  <div class="text-light text-center m-5">
    Secret! but empty... Like my Soul
  </div>

  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</body>
</html>
