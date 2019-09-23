var t;

t=outlookbar.addtitle('修改密码')
outlookbar.additem('密码修改',t,'/book/admin/userinfo/userPw.jsp')

t=outlookbar.addtitle('用户管理')
outlookbar.additem('用户管理',t,'/book/userMana.action')

t=outlookbar.addtitle('图书类别')
outlookbar.additem('类别管理',t,'/book/catelogMana.action')
outlookbar.additem('添加类别',t,'/book/admin/catelog/catelogAdd.jsp')

t=outlookbar.addtitle('图书管理')
outlookbar.additem('图书管理',t,'/book/goodsMana.action')
outlookbar.additem('添加图书',t,'/book/admin/goods/goodsAdd.jsp')

t=outlookbar.addtitle('订单管理')
outlookbar.additem('订单管理',t,'/book/xiaoshouMine.action')

t=outlookbar.addtitle('留言管理')
outlookbar.additem('留言管理',t,'/book/liuyanMana.action')

t=outlookbar.addtitle('公告管理')
outlookbar.additem('公告管理',t,'/book/gonggaoMana.action')
outlookbar.additem('添加公告',t,'/book/admin/gonggao/gonggaoAdd.jsp')

t=outlookbar.addtitle('评价管理')
outlookbar.additem('评价管理',t,'/book/commentMana.action')

t=outlookbar.addtitle('退出系统') 
outlookbar.additem('安全退出',t,'/book/login.jsp')