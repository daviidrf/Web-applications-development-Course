<p>Login form</p>
<form action="" method="post">
  <div class="mb-3">
    <label for="name">Name</label>
    <input type="text" class="form-control" name="name" value="<?php if (isset($_POST["name"]))echo $_POST["name"];?>" placeholder="Name" required><br/>
    <label for="description">Password</label>
    <input type="password" class="form-control" name="password" value="<?php if (isset($_POST["password"]))echo $_POST["password"];?>" placeholder="Password" required><br/>
    <input type="submit" class="btn btn-primary" name="action" value="login"/>
  </div>
</form>
