<p>Add category form</p>
<form action="" method="post">
  <div class="mb-3">
    <label for="name">Name</label>
    <input type="text" class="form-control" name="name" value="<?php if (isset($_POST["name"]))echo $_POST["name"];?>" placeholder="Name" required><br/>
    <label for="description">Description</label>
    <input type="text" class="form-control" name="description" value="<?php if (isset($_POST["description"]))echo $_POST["description"];?>" placeholder="Description" required><br/>
    <input type="submit" class="btn btn-primary" name="action" value="add"/>
  </div>
</form>
