# Navigation Graph x Modular

### - Use Navigation with Modular
### - Use Koin, ReactiveX, Retrofit
### - Navigate to activity, fragment between module
### - Parsing parameter with navigation


### List of Modular

#### App Module
```
    - MainActivity
    - MainFragment
```

#### Me Module
```
    - MeActivity
    - MeFragment
    - AccountFragment
    - InboxFragment
    - EditProfileFragment
    - InboxModel
```

#### Article Module
```
    - ArticleActivity
    - ArticleFragment
    - Request Api
```

#### Episode Module
```
    - EpisodeFragment
```


### Modular Structure

| Module                          | Connect with                                                    |
|---------------------------------|-----------------------------------------------------------------|
| App                             | Me, Article                                                     |
| Me                              | Episode                                                         |
| Article                         | -                                                               |
| Episode                         | -                                                               |
