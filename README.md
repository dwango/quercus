Quercus
=======
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

    <repositories>
		<repository>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
			<id>dwango-quercus-repos</id>
			<name>Dwango Quercus Repository</name>
			<url>https://raw.github.com/dwango/quercus/master/repos/</url>
		</repository>
	</repositories>