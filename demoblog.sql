/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : demoblog

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2015-04-11 20:43:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `cateid` int(11) NOT NULL,
  `isrecover` int(1) NOT NULL,
  `staticurl` varchar(255) DEFAULT NULL,
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `contentSource` text,
  PRIMARY KEY (`id`),
  KEY `fk_article_tag` (`tags`),
  KEY `fk_cate_id` (`cateid`),
  CONSTRAINT `fk_cate_id` FOREIGN KEY (`cateid`) REFERENCES `blog_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES ('1', '世界 , 你好 !', '欢迎使用DemoBlog。这是系统自动生成的演示文章。编辑或者删除它，然后开始您的博客！', '欢迎使用DemoBlog。这是系统自动生成的演示文章。编辑或者删除它，然后开始您的博客！', '1', '2', '1', 'helloword', '2015-04-07 16:41:44', null);
INSERT INTO `blog_article` VALUES ('2', '超简单实现Centos 7 终端透明', '最近一直没时间来管理博客，一直在忙着学习。这两天装了一个centos 7 ，安装过程也是让我伤心，把陪伴我2年的本本的主板烧了。\r\n\r\n由于是linux的新手，也没有用过yum，所以在使用过程中一直碰壁，不过还好，我就没装win，所以这也算是强制我学习linux的各种使用了。\r\n\r\n看着终端的背景有一种说不出的感觉，就是想换，后来知道可以让背景透明。这是一个很不错的选择，使用vim的时候还可以一边看文档，一边写代码。感觉很棒。google良久之后终于找到了解决的办法：\r\n从 3.7 开始，GNOME Terminal 暂时移除了背景透明的特性。GNOME 官方给出了两种办法：一是，使用窗口匹配工具 Devilspie 或 Devilspie2，为 GNOME Terminal 写一个匹配规则，用来使其窗口透明（KDE 不都自带这功能么？）；二是，使用一个脚本，在每次需要让 GNOME Terminal 窗口透明时，执行一下。详见：GNOME Terminal FAQ\r\n\r\n另外，在 GNOME Bugzilla 上，网友 lvqier 给出了一个方法，让 GNOME Terminal 在启动时运行一个设置其窗口为透明的脚本。详见：GNOME Bugzilla', '看着终端的背景有一种说不出的感觉，就是想换，后来知道可以让背景透明。这是一个很不错的选择，使用vim的时候还可以一边看文档，一边写代码。感觉很棒。', '2', '1', '1', 'centos-7-terminal-transparent', '2015-04-07 16:43:51', null);
INSERT INTO `blog_article` VALUES ('3', '测试标题', '<p>这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.这里是测试文章的正文内容.</p>\n', '这里是测试文章1的内容描述,主要应用于首页展示文章信息.', '1', '1', '1', 'testarticle', '2015-04-11 14:47:57', null);
INSERT INTO `blog_article` VALUES ('4', 'markdown功能测试', '<h1>Markdown 功能测试</h1>\n<blockquote><ul>\n<li>整理知识，学习笔记</li>\n<li>发布日记，杂文，所见所想</li>\n<li>撰写发布技术文稿（代码支持）</li>\n<li>撰写发布学术论文（LaTeX 公式支持）</li>\n</ul>\n</blockquote>\n', '测试markdown功能是否可用.测试markdown功能是否可用.', '2,1', '4', '1', 'markdowntest', '2015-04-11 14:54:17', null);
INSERT INTO `blog_article` VALUES ('5', 'CMD Markdown测试内容', '<hr />\n<p>我们理解您需要更便捷更高效的工具记录思想，整理笔记、知识，并将其中承载的价值传播给他人，<strong>Cmd Markdown</strong> 是我们给出的答案 —— 我们为记录思想和分享知识提供更专业的工具。</p>\n<p>您可以使用 Cmd Markdown：</p>\n<blockquote><ul>\n<li>整理知识，学习笔记</li>\n<li>发布日记，杂文，所见所想</li>\n<li>撰写发布技术文稿（代码支持）</li>\n<li>撰写发布学术论文（LaTeX 公式支持）</li>\n</ul>\n</blockquote>\n<p>请保留此份 Cmd Markdown 的欢迎稿兼使用说明，如需撰写新稿件，点击顶部工具栏右侧的 <i class=\"icon-file\"></i> <strong>新文稿</strong> 或者使用快捷键 <code>Ctrl+Alt+N</code>。</p>\n<hr />\n<h2>什么是 Markdown</h2>\n<p>Markdown 是一种方便记忆、书写的纯文本标记语言，用户可以使用这些标记符号以最小的输入代价生成极富表现力的文档：譬如您正在阅读的这份文档。它使用简单的符号标记不同的标题，分割不同的段落，<strong>粗体</strong> 或者 <em>斜体</em> 某些文字，更棒的是，它还可以</p>\n<h3>书写一个质能守恒公式[^LaTeX]</h3>\n<p>$$E=mc^2$$</p>\n<h3>高亮一段代码[^code]</h3>\n<pre><code class=\"python\">@requires_authorization\nclass SomeClass:\n    pass\n\nif __name__ == \'__main__\':\n    # A comment\n    print \'hello world\'\n</code></pre>\n<h3>高效绘制 <a href=\"https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#7-流程图\">流程图</a></h3>\n<pre><code class=\"flow\">st=&gt;start: Start\nop=&gt;operation: Your Operation\ncond=&gt;condition: Yes or No?\ne=&gt;end\n\nst-&gt;op-&gt;cond\ncond(yes)-&gt;e\ncond(no)-&gt;op\n</code></pre>\n<h3>高效绘制 <a href=\"https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#8-序列图\">序列图</a></h3>\n<pre><code class=\"seq\">Alice-&gt;Bob: Hello Bob, how are you?\nNote right of Bob: Bob thinks\nBob--&gt;Alice: I am good thanks!\n</code></pre>\n<h3>绘制表格</h3>\n<p>| 项目        | 价格   |  数量  |\n<br  />| &mdash;&mdash;&ndash;   | &mdash;&ndash;:  | :&mdash;-:  |\n<br  />| 计算机     | $1600 |   5     |\n<br  />| 手机        |   $12   |   12   |\n<br  />| 管线        |    $1    |  234  |</p>\n<h3>更详细语法说明</h3>\n<p>想要查看更详细的语法说明，可以参考我们准备的 <a href=\"https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown\">Cmd Markdown 简明语法手册</a>，进阶用户可以参考 <a href=\"https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#cmd-markdown-高阶语法手册\">Cmd Markdown 高阶语法手册</a> 了解更多高级功能。</p>\n<p>总而言之，不同于其它 <em>所见即所得</em> 的编辑器：你只需使用键盘专注于书写文本内容，就可以生成印刷级的排版格式，省却在键盘和工具栏之间来回切换，调整内容和格式的麻烦。<strong>Markdown 在流畅的书写和印刷级的阅读体验之间找到了平衡。</strong> 目前它已经成为世界上最大的技术分享网站 GitHub 和 技术问答网站 StackOverFlow 的御用书写格式。</p>\n<hr />\n<h2>什么是 Cmd Markdown</h2>\n<p>您可以使用很多工具书写 Markdown，但是 Cmd Markdown 是这个星球上我们已知的、最好的 Markdown 工具——没有之一 ：）因为深信文字的力量，所以我们和你一样，对流畅书写，分享思想和知识，以及阅读体验有极致的追求，我们把对于这些诉求的回应整合在 Cmd Markdown，并且一次，两次，三次，乃至无数次地提升这个工具的体验，最终将它演化成一个 <strong>编辑/发布/阅读</strong> Markdown 的在线平台——您可以在任何地方，任何系统/设备上管理这里的文字。</p>\n<h3>1. 实时同步预览</h3>\n<p>我们将 Cmd Markdown 的主界面一分为二，左边为<strong>编辑区</strong>，右边为<strong>预览区</strong>，在编辑区的操作会实时地渲染到预览区方便查看最终的版面效果，并且如果你在其中一个区拖动滚动条，我们有一个巧妙的算法把另一个区的滚动条同步到等价的位置，超酷！</p>\n<h3>2. 编辑工具栏</h3>\n<p>也许您还是一个 Markdown 语法的新手，在您完全熟悉它之前，我们在 <strong>编辑区</strong> 的顶部放置了一个如下图所示的工具栏，您可以使用鼠标在工具栏上调整格式，不过我们仍旧鼓励你使用键盘标记格式，提高书写的流畅度。</p>\n<p><img src=\"https://www.zybuluo.com/static/img/toolbar-editor.png\" alt=\"tool-editor\" /></p>\n<h3>3. 编辑模式</h3>\n<p>完全心无旁骛的方式编辑文字：点击 <strong>编辑工具栏</strong> 最右测的拉伸按钮或者按下 <code>Ctrl + M</code>，将 Cmd Markdown 切换到独立的编辑模式，这是一个极度简洁的写作环境，所有可能会引起分心的元素都已经被挪除，超清爽！</p>\n<h3>4. 实时的云端文稿</h3>\n<p>为了保障数据安全，Cmd Markdown 会将您每一次击键的内容保存至云端，同时在 <strong>编辑工具栏</strong> 的最右侧提示 <code>已保存</code> 的字样。无需担心浏览器崩溃，机器掉电或者地震，海啸——在编辑的过程中随时关闭浏览器或者机器，下一次回到 Cmd Markdown 的时候继续写作。</p>\n<h3>5. 离线模式</h3>\n<p>在网络环境不稳定的情况下记录文字一样很安全！在您写作的时候，如果电脑突然失去网络连接，Cmd Markdown 会智能切换至离线模式，将您后续键入的文字保存在本地，直到网络恢复再将他们传送至云端，即使在网络恢复前关闭浏览器或者电脑，一样没有问题，等到下次开启 Cmd Markdown 的时候，她会提醒您将离线保存的文字传送至云端。简而言之，我们尽最大的努力保障您文字的安全。</p>\n<h3>6. 管理工具栏</h3>\n<p>为了便于管理您的文稿，在 <strong>预览区</strong> 的顶部放置了如下所示的 <strong>管理工具栏</strong>：</p>\n<p><img src=\"https://www.zybuluo.com/static/img/toolbar-manager.jpg\" alt=\"tool-manager\" /></p>\n<p>通过管理工具栏可以：</p>\n<p><i class=\"icon-share\"></i> 发布：将当前的文稿生成固定链接，在网络上发布，分享\n<br  /><i class=\"icon-file\"></i> 新建：开始撰写一篇新的文稿\n<br  /><i class=\"icon-trash\"></i> 删除：删除当前的文稿\n<br  /><i class=\"icon-cloud\"></i> 导出：将当前的文稿转化为 Markdown 文本或者 Html 格式，并导出到本地\n<br  /><i class=\"icon-reorder\"></i> 列表：所有新增和过往的文稿都可以在这里查看、操作\n<br  /><i class=\"icon-pencil\"></i> 模式：切换 普通/Vim/Emacs 编辑模式</p>\n<h3>7. 阅读工具栏</h3>\n<p><img src=\"https://www.zybuluo.com/static/img/toolbar-reader.jpg\" alt=\"tool-manager\" /></p>\n<p>通过 <strong>预览区</strong> 右上角的 <strong>阅读工具栏</strong>，可以查看当前文稿的目录并增强阅读体验。</p>\n<p>工具栏上的五个图标依次为：</p>\n<p><i class=\"icon-list\"></i> 目录：快速导航当前文稿的目录结构以跳转到感兴趣的段落\n<br  /><i class=\"icon-chevron-sign-left\"></i> 视图：互换左边编辑区和右边预览区的位置\n<br  /><i class=\"icon-adjust\"></i> 主题：内置了黑白两种模式的主题，试试 <strong>黑色主题</strong>，超炫！\n<br  /><i class=\"icon-desktop\"></i> 阅读：心无旁骛的阅读模式提供超一流的阅读体验\n<br  /><i class=\"icon-fullscreen\"></i> 全屏：简洁，简洁，再简洁，一个完全沉浸式的写作和阅读环境</p>\n<h3>8. 阅读模式</h3>\n<p>在 <strong>阅读工具栏</strong> 点击 <i class=\"icon-desktop\"></i> 或者按下 <code>Ctrl+Alt+M</code> 随即进入独立的阅读模式界面，我们在版面渲染上的每一个细节：字体，字号，行间距，前背景色都倾注了大量的时间，努力提升阅读的体验和品质。</p>\n<h3>9. 标签、分类和搜索</h3>\n<p>在编辑区任意行首位置输入以下格式的文字可以标签当前文档：</p>\n<p>标签： 未分类</p>\n<p>标签以后的文稿在【文件列表】（Ctrl+Alt+F）里会按照标签分类，用户可以同时使用键盘或者鼠标浏览查看，或者在【文件列表】的搜索文本框内搜索标题关键字过滤文稿，如下图所示：</p>\n<p><img src=\"https://www.zybuluo.com/static/img/file-list.png\" alt=\"file-list\" /></p>\n<h3>10. 文稿发布和分享</h3>\n<p>在您使用 Cmd Markdown 记录，创作，整理，阅读文稿的同时，我们不仅希望它是一个有力的工具，更希望您的思想和知识通过这个平台，连同优质的阅读体验，将他们分享给有相同志趣的人，进而鼓励更多的人来到这里记录分享他们的思想和知识，尝试点击 <i class=\"icon-share\"></i> (Ctrl+Alt+P) 发布这份文档给好友吧！</p>\n<hr />\n<p>再一次感谢您花费时间阅读这份欢迎稿，点击 <i class=\"icon-file\"></i> (Ctrl+Alt+N) 开始撰写新的文稿吧！祝您在这里记录、阅读、分享愉快！</p>\n<p>作者 <a href=\"http://weibo.com/ghosert\">@ghosert</a>\n<br  />2014 年 07月 07日</p>\n<p>[<sup>LaTeX]: 支持 <strong>LaTeX</strong> 编辑显示支持，例如：$\\sum_{i=1}</sup>n a_i=0$， 访问 <a href=\"http://meta.math.stackexchange.com/questions/5020/mathjax-basic-tutorial-and-quick-reference\">MathJax</a> 参考更多使用方法。</p>\n<p>[^code]: 代码高亮功能支持包括 Java, Python, JavaScript 在内的，<strong>四十一</strong>种主流编程语言。</p>\n', 'CMD markdown测试内容', '2', '1', '1', 'cmdmarkdown', '2015-04-11 15:08:11', '------\n\n我们理解您需要更便捷更高效的工具记录思想，整理笔记、知识，并将其中承载的价值传播给他人，**Cmd Markdown** 是我们给出的答案 —— 我们为记录思想和分享知识提供更专业的工具。\n\n您可以使用 Cmd Markdown：\n\n> * 整理知识，学习笔记\n> * 发布日记，杂文，所见所想\n> * 撰写发布技术文稿（代码支持）\n> * 撰写发布学术论文（LaTeX 公式支持）\n\n请保留此份 Cmd Markdown 的欢迎稿兼使用说明，如需撰写新稿件，点击顶部工具栏右侧的 <i class=\"icon-file\"></i> **新文稿** 或者使用快捷键 `Ctrl+Alt+N`。\n\n------\n\n## 什么是 Markdown\n\nMarkdown 是一种方便记忆、书写的纯文本标记语言，用户可以使用这些标记符号以最小的输入代价生成极富表现力的文档：譬如您正在阅读的这份文档。它使用简单的符号标记不同的标题，分割不同的段落，**粗体** 或者 *斜体* 某些文字，更棒的是，它还可以\n\n### 书写一个质能守恒公式[^LaTeX]\n\n$$E=mc^2$$\n\n### 高亮一段代码[^code]\n\n```python\n@requires_authorization\nclass SomeClass:\n    pass\n\nif __name__ == \'__main__\':\n    # A comment\n    print \'hello world\'\n```\n\n### 高效绘制 [流程图](https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#7-流程图)\n\n```flow\nst=>start: Start\nop=>operation: Your Operation\ncond=>condition: Yes or No?\ne=>end\n\nst->op->cond\ncond(yes)->e\ncond(no)->op\n```\n\n### 高效绘制 [序列图](https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#8-序列图)\n\n```seq\nAlice->Bob: Hello Bob, how are you?\nNote right of Bob: Bob thinks\nBob-->Alice: I am good thanks!\n```\n\n### 绘制表格\n\n| 项目        | 价格   |  数量  |\n| --------   | -----:  | :----:  |\n| 计算机     | $1600 |   5     |\n| 手机        |   $12   |   12   |\n| 管线        |    $1    |  234  |\n\n### 更详细语法说明\n\n想要查看更详细的语法说明，可以参考我们准备的 [Cmd Markdown 简明语法手册][1]，进阶用户可以参考 [Cmd Markdown 高阶语法手册][2] 了解更多高级功能。\n\n总而言之，不同于其它 *所见即所得* 的编辑器：你只需使用键盘专注于书写文本内容，就可以生成印刷级的排版格式，省却在键盘和工具栏之间来回切换，调整内容和格式的麻烦。**Markdown 在流畅的书写和印刷级的阅读体验之间找到了平衡。** 目前它已经成为世界上最大的技术分享网站 GitHub 和 技术问答网站 StackOverFlow 的御用书写格式。\n\n---\n\n## 什么是 Cmd Markdown\n\n您可以使用很多工具书写 Markdown，但是 Cmd Markdown 是这个星球上我们已知的、最好的 Markdown 工具——没有之一 ：）因为深信文字的力量，所以我们和你一样，对流畅书写，分享思想和知识，以及阅读体验有极致的追求，我们把对于这些诉求的回应整合在 Cmd Markdown，并且一次，两次，三次，乃至无数次地提升这个工具的体验，最终将它演化成一个 **编辑/发布/阅读** Markdown 的在线平台——您可以在任何地方，任何系统/设备上管理这里的文字。\n\n### 1. 实时同步预览\n\n我们将 Cmd Markdown 的主界面一分为二，左边为**编辑区**，右边为**预览区**，在编辑区的操作会实时地渲染到预览区方便查看最终的版面效果，并且如果你在其中一个区拖动滚动条，我们有一个巧妙的算法把另一个区的滚动条同步到等价的位置，超酷！\n\n### 2. 编辑工具栏\n\n也许您还是一个 Markdown 语法的新手，在您完全熟悉它之前，我们在 **编辑区** 的顶部放置了一个如下图所示的工具栏，您可以使用鼠标在工具栏上调整格式，不过我们仍旧鼓励你使用键盘标记格式，提高书写的流畅度。\n\n![tool-editor](https://www.zybuluo.com/static/img/toolbar-editor.png)\n\n### 3. 编辑模式\n\n完全心无旁骛的方式编辑文字：点击 **编辑工具栏** 最右测的拉伸按钮或者按下 `Ctrl + M`，将 Cmd Markdown 切换到独立的编辑模式，这是一个极度简洁的写作环境，所有可能会引起分心的元素都已经被挪除，超清爽！\n\n### 4. 实时的云端文稿\n\n为了保障数据安全，Cmd Markdown 会将您每一次击键的内容保存至云端，同时在 **编辑工具栏** 的最右侧提示 `已保存` 的字样。无需担心浏览器崩溃，机器掉电或者地震，海啸——在编辑的过程中随时关闭浏览器或者机器，下一次回到 Cmd Markdown 的时候继续写作。\n\n### 5. 离线模式\n\n在网络环境不稳定的情况下记录文字一样很安全！在您写作的时候，如果电脑突然失去网络连接，Cmd Markdown 会智能切换至离线模式，将您后续键入的文字保存在本地，直到网络恢复再将他们传送至云端，即使在网络恢复前关闭浏览器或者电脑，一样没有问题，等到下次开启 Cmd Markdown 的时候，她会提醒您将离线保存的文字传送至云端。简而言之，我们尽最大的努力保障您文字的安全。\n\n### 6. 管理工具栏\n\n为了便于管理您的文稿，在 **预览区** 的顶部放置了如下所示的 **管理工具栏**：\n\n![tool-manager](https://www.zybuluo.com/static/img/toolbar-manager.jpg)\n\n通过管理工具栏可以：\n\n<i class=\"icon-share\"></i> 发布：将当前的文稿生成固定链接，在网络上发布，分享\n<i class=\"icon-file\"></i> 新建：开始撰写一篇新的文稿\n<i class=\"icon-trash\"></i> 删除：删除当前的文稿\n<i class=\"icon-cloud\"></i> 导出：将当前的文稿转化为 Markdown 文本或者 Html 格式，并导出到本地\n<i class=\"icon-reorder\"></i> 列表：所有新增和过往的文稿都可以在这里查看、操作\n<i class=\"icon-pencil\"></i> 模式：切换 普通/Vim/Emacs 编辑模式\n\n### 7. 阅读工具栏\n\n![tool-manager](https://www.zybuluo.com/static/img/toolbar-reader.jpg)\n\n通过 **预览区** 右上角的 **阅读工具栏**，可以查看当前文稿的目录并增强阅读体验。\n\n工具栏上的五个图标依次为：\n\n<i class=\"icon-list\"></i> 目录：快速导航当前文稿的目录结构以跳转到感兴趣的段落\n<i class=\"icon-chevron-sign-left\"></i> 视图：互换左边编辑区和右边预览区的位置\n<i class=\"icon-adjust\"></i> 主题：内置了黑白两种模式的主题，试试 **黑色主题**，超炫！\n<i class=\"icon-desktop\"></i> 阅读：心无旁骛的阅读模式提供超一流的阅读体验\n<i class=\"icon-fullscreen\"></i> 全屏：简洁，简洁，再简洁，一个完全沉浸式的写作和阅读环境\n\n### 8. 阅读模式\n\n在 **阅读工具栏** 点击 <i class=\"icon-desktop\"></i> 或者按下 `Ctrl+Alt+M` 随即进入独立的阅读模式界面，我们在版面渲染上的每一个细节：字体，字号，行间距，前背景色都倾注了大量的时间，努力提升阅读的体验和品质。\n\n### 9. 标签、分类和搜索\n\n在编辑区任意行首位置输入以下格式的文字可以标签当前文档：\n\n标签： 未分类\n\n标签以后的文稿在【文件列表】（Ctrl+Alt+F）里会按照标签分类，用户可以同时使用键盘或者鼠标浏览查看，或者在【文件列表】的搜索文本框内搜索标题关键字过滤文稿，如下图所示：\n\n![file-list](https://www.zybuluo.com/static/img/file-list.png)\n\n### 10. 文稿发布和分享\n\n在您使用 Cmd Markdown 记录，创作，整理，阅读文稿的同时，我们不仅希望它是一个有力的工具，更希望您的思想和知识通过这个平台，连同优质的阅读体验，将他们分享给有相同志趣的人，进而鼓励更多的人来到这里记录分享他们的思想和知识，尝试点击 <i class=\"icon-share\"></i> (Ctrl+Alt+P) 发布这份文档给好友吧！\n\n------\n\n再一次感谢您花费时间阅读这份欢迎稿，点击 <i class=\"icon-file\"></i> (Ctrl+Alt+N) 开始撰写新的文稿吧！祝您在这里记录、阅读、分享愉快！\n\n作者 [@ghosert][3]     \n2014 年 07月 07日    \n\n[^LaTeX]: 支持 **LaTeX** 编辑显示支持，例如：$\\sum_{i=1}^n a_i=0$， 访问 [MathJax][4] 参考更多使用方法。\n\n[^code]: 代码高亮功能支持包括 Java, Python, JavaScript 在内的，**四十一**种主流编程语言。\n\n[1]: https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown\n[2]: https://www.zybuluo.com/mdeditor?url=https://www.zybuluo.com/static/editor/md-help.markdown#cmd-markdown-高阶语法手册\n[3]: http://weibo.com/ghosert\n[4]: http://meta.math.stackexchange.com/questions/5020/mathjax-basic-tutorial-and-quick-reference\n');

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `parentId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_category
-- ----------------------------
INSERT INTO `blog_category` VALUES ('1', '个人开发', '0');
INSERT INTO `blog_category` VALUES ('2', '编程语言', '0');
INSERT INTO `blog_category` VALUES ('3', '资源分享', '0');
INSERT INTO `blog_category` VALUES ('4', '操作系统', '0');
INSERT INTO `blog_category` VALUES ('5', '建站资源', '0');
INSERT INTO `blog_category` VALUES ('6', '网　　摘', '0');
INSERT INTO `blog_category` VALUES ('7', '留　　言', '0');
INSERT INTO `blog_category` VALUES ('8', '关　　于', '0');

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `parentId` int(11) NOT NULL,
  `articleId` int(11) NOT NULL,
  `userNeme` varchar(255) NOT NULL,
  `userEmail` varchar(255) NOT NULL,
  `userLink` varchar(255) NOT NULL,
  `isrecover` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_article_id` (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_link
-- ----------------------------
DROP TABLE IF EXISTS `blog_link`;
CREATE TABLE `blog_link` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `random` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_link
-- ----------------------------

-- ----------------------------
-- Table structure for blog_system
-- ----------------------------
DROP TABLE IF EXISTS `blog_system`;
CREATE TABLE `blog_system` (
  `title` varchar(255) NOT NULL,
  `key` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `icp` varchar(500) DEFAULT NULL,
  `seo` varchar(255) DEFAULT NULL,
  `readonly` int(11) NOT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_system
-- ----------------------------
INSERT INTO `blog_system` VALUES ('Demo', 'JAVA', 'DemoBlog', '暂无', 'demoblog', '1', 'http://localhost:8080/demoblog/');

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES ('1', '测试内容');
INSERT INTO `blog_tag` VALUES ('2', 'WEB前端');

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
