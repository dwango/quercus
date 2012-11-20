Quercus
=======

# 改変内容
http://suzuki0keiichi.hatenablog.com/entry/2012/11/18/130823
で指摘されている不具合に対応しています。本家にフィードバックすべきですが、とりあえず自分たち用に修正したものを公開しています。いずれに本家にフィードバックしたいとおもいます。

# ビルド方法
## ビルド環境
- JDK6(JDK7ではビルドできません)
- Mavn2以降

## ビルド方法

    $ mvn clean package

targetディレクトリにquercus-VERSION.jarが生成されます。

## デプロイ方法

    $ mvn clean deploy
    $ git add repos
    $ git commit repos -m '....'
    $ git push origin master

# Mavenプロジェクトで利用する方法
pom.xmlに以下のようにリポジトリとjarへの依存関係を追加する。

    <repositories>
        // ...
        <repository>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            <id>dwango-quercus-repos</id>
            <name>Dwango Quercus Repository</name>
            <url>https://raw.github.com/dwango/quercus/master/repos/</url>
        </repository>
        //...
    </repositories>
    // ...
    <dependencies>
        // ...
        <dependency>
            <groupId>com.caucho</groupId>
            <artifactId>quercus</artifactId>
            <version>4.0.25</version>
        </dependency>
        // ...
    </dependencies>