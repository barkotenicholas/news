# News Portal Api
- This application is an apis for news portal
----
**Version1.0.0**

---
![APM](https://img.shields.io/apm/l/vim-mode)
---
| route                   | pourpose                                            |
|-------------------------|-----------------------------------------------------|
| get("/")                | retuns a list of api routes                         |
| get("/department")      | Returns a list of all departments                   |
| get("/department/:id")  | Returns a department with specific                  |
| post("/department/new") | create a new department                             |
| get("/users")           | Returns a list of users                             |
| get("/users/:id")       | Returns a user with the specific id                 |
| post("/user/new/:id")   | creates a user and associates it with department id |
| get("/news")            | returns a list of general news created              |
| post("/news/new")       | creates general news                                |
| get("/department/news") | returns a list of department news                   |
| post("/department/:id/news/new") | creates news for a specific department              |
---

## Authors
- Nicholas Barkote <nicholas.kebut@student.moringaschool.com>
---

## Requirements
- ubuntu or any os with jdk
- IntelliJ


## Setup Instructions

* clone it to your desktop
```bash
 git clone  https://github.com/barkotenicholas/news.git
   ```
* Open the project with intellij

# Tech Stack

- java
- gradle



## Contact Information

<a href="mailto:barkotenicholas@gmail.com">barkotenicholas@gmail.com</a>



## License & copyright

© Nicholas k Barkote , Moringa school student

Licensed under the [MIT License](LICENSE)