![super-secret-users-db](https://socialify.git.ci/johny7guitar/super-secret-users-db/image?font=Raleway&language=1&name=1&owner=1&pattern=Brick%20Wall&theme=Dark)
# Task Description
Implement REST API based on given [description](https://johny7guitar.github.io/super-secret-users-db/)

## Table of content
* [Technologies](#technologies)
* [Setup](#setup)
* [Usage](#usage)

## Technologies
* Java 1.8
* Spring Boot 2.7.10

## Setup

### Requirements
* MySQL or Docker

For setup MySQL with Docker:

```
$ docker compose up
```

Run on Linux

```
$ bash gradlew bootRun
```

## Usage

### Add user

```
$ POST /users
```
#### Body parameters for "Add user"
| Name     | Description                                             | Type     |
|----------|---------------------------------------------------------|----------|
| `username` | Username(4 - 24 symbols only latin letters or numbers** | *String* |
| `email`    | Valid email adress                                      | *String* |
|`userpic`| Valid URL                                               | *String* |
|`userStatus`| Case-sensitive value "OFFLINE" or "ONLINE"              | *String* |

#### Return example
```yaml
{
  "user_id": 3,
  "_links": {
    "self": {
      "href": "/users/3"
    }
  }
}
```
-----------------------------

### Get user
```
$ GET /users/{id}
```
#### Return example
```yaml
{
  "user": {
    "id": 4,
    "username": "red7john",
    "email": "johnred@findme.com",
    "userpic": "https://i.imgur.com/M8xQTxi.png",
    "userStatus": "ONLINE"
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/users/4"
    }
  }
}
```
-----

### Update user status
Updates user status to **ONLINE** or **OFFLINE** 

```
$ PATCH /users/{id}/update_status/{new_status}
```
#### Path parameters

| Name        |Description|
|-------------|-----------|
| `id`        | User id|
| `new_status` | New user status. String with "ONLINE" or "OFFLINE" value case insensitive|

#### Return example
```yaml
{
  "user_id": 1,
  "old_status": "ONLINE",
  "new_status": "OFFLINE",
  "_links": {
    "self": {
      "href": "/users/1/update_status/OFFLINE"
    }
  }
}
```

