package `in`.raji.bills.retrosample.retro.data

data class Post(var userId:Int,var id:Int,var title:String,var body:String)
   object posts{
       var posts:ArrayList<Post>?=null
   }