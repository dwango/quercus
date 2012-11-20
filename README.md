Quercus
=======

# ビルド環境
- JDK6(JDK7ではビルドできません)
- Mavn2以降

# ビルド方法
``$ mvn clean package``

# デプロイ方法

    $ mvn clean deploy
    $ git add repos
    $ git commit repos -m '....'
    $ git push origin master

# Mavenプロジェクトで利用する方法