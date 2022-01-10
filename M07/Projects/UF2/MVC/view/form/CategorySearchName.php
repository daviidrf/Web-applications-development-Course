<p>Search category by name</p>
<form action="" method="post">
  <div class="mb-3">
    <label for="name">Name</label>
    <input type="text" class="form-control" name="name" value="<?php if (isset($_POST["name"]))echo $_POST["name"];?>" placeholder="Name" required><br/>
    <input type="submit" class="btn btn-primary" name="action" value="search">
  </div>
</form>
