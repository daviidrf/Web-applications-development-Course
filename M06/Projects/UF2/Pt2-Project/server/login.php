<?php

// Array of the users in the Server
$users = array(
    (object) [
        'username' => 'user1',
        'password' => 'pass1',
        'role' => 'operari'
    ],
    (object) [
        'username' => 'user2',
        'password' => 'pass2',
        'role' => 'encarregat'
    ],
    (object) [
        'username' => 'user3',
        'password' => 'pass3',
        'role' => 'client'
    ]
);


if (isset($_POST['username']) && $_POST['username'] && isset($_POST['password']) && $_POST['password']) {
    // Do user authentication as per your requirements
    // Based on successful authentication
    $username = $_POST['username'];
    $password = $_POST['password'];
    $validated = false;

    foreach ($users as $user) {
        if($user->username == $username &&
            $user->password == $password) {
                $validated = true;
                $userToReturn = $user;
            }
    }

    if($validated) {
        echo json_encode(array('success' => 1,'user' => $userToReturn));

    } else {
        echo json_encode(array('success' => 0));

    }
} else {
    echo json_encode(array('success' => 0));
}
