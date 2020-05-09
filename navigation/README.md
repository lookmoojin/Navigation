# Navigation Graph Guidelines

### - Setup
### - Navigate to activity, fragment
### - Parsing parameter


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
