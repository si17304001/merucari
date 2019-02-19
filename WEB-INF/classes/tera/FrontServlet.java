/*
package宣言
package名tera
import文宣言
IOException
Map
servletのRequsetDispacther
servletのServletException
servletのHttpServletRequest
servletのHttpServletResponse
*/
package tera;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
class宣言
	継承して使いたいからHttpServlertの完全限定名
	*/
public class FrontServlet extends javax.servlet.http.HttpServlet{
	/*
	同一のpackage内とそのクラスを継承したサブクラス内から
	そのサブクラスへの参照を通してアクセスできるようにprotected
	HttpGetリクエストを呼び出すために、doGet()メソッドで書く必要がある
	(リクエストのHttp()メソッドがDelete()メソッドであった場合に呼び出されるメソッド)
	変数はreq,res
	throwsでServletExceptionとIOException
	*/
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException,ServletException{
		//doPostでreq,resを呼びだす
		doPost(req,res);
	}
	/*
	どのクラスからもアクセスできるようにpublic
	HttpServletクラスdoPost()のメソッドをオーバーライドしたもの
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		
		//文字コードの設定。変数req
		req.setCharacterEncoding("utf-8");
		
		/*
		Mapクラス型の変数dataを宣言して
		MapクラスからrequestしてgetParameterMap()メソッドでパラメータを受け取る
		
		Map data=req.getParameterMap();
		*/
		ApplicationController app = new WebApplicationController();
		
		RequestContext reqc = app.getRequest(req);
		
		ResponseContext resc = app.handleRequest(reqc);
		
		resc.setResponse(res);
		app.handleResponse(reqc, resc);
		/*
		Stringクラス型の変数pathを宣言して
		StringクラスからgetServletPath()メソッドでサーブレットパスを取得し
		ConcreteCommandを取得
		*/
		//String path=req.getServletPath();
		
		/*
		AbstractCommandクラス型の変数commandを宣言し
		AbstractCommandクラスからgetCommand()メソッドでパラメータを受け取る
		*/
		//AbstractCommand command = CommandFactory.getCommand(path);
		
		/*
		インスタンスの初回作成時に実行するからinit()メソッド
		コア処理に入力パラメータ(data)を渡す
		*/
		//command.init(data);
		
		/*
		コア処理を実行し、戻り値としてViewの情報を取得する
		Stringクラス型の変数urlを宣言し
		Stringクラスからexecute()メソッドでパラメータを受け取ってコア処理を実行
		*/
		//String url=command.execute();
		
		/*
		コア処理を実行結果を取得し、登録処理を行う
		jspでの表示に利用
		Objectクラス型の変数resultを宣言しgetResult()メソッドでパラメータを受け取って
		実行結果を取得、登録処理を行う
		*/
		//Object result=command.getResult();
		
		/*
		setAttribute()メソッドでrequestされたパラメータをresultに格納
		*/
		//req.setAttribute("result",result);
		
		/*
		RequsetDispactherクラス型の変数dispatcherを宣言しgetRequestDispatcher()メソッドでurlを取得
		*/
		//RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		
		/*
		転送先に要求を転送する
		forward()メソッドに変数req、resを格納しdispatcherに返す
		*/
		//dispatcher.forward(req,res);
	}
}
