/*
package�錾
package��tera
import���錾
IOException
Map
servlet��RequsetDispacther
servlet��ServletException
servlet��HttpServletRequest
servlet��HttpServletResponse
*/
package tera;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
class�錾
	�p�����Ďg����������HttpServlert�̊��S���薼
	*/
public class FrontServlet extends javax.servlet.http.HttpServlet{
	/*
	�����package���Ƃ��̃N���X���p�������T�u�N���X������
	���̃T�u�N���X�ւ̎Q�Ƃ�ʂ��ăA�N�Z�X�ł���悤��protected
	HttpGet���N�G�X�g���Ăяo�����߂ɁAdoGet()���\�b�h�ŏ����K�v������
	(���N�G�X�g��Http()���\�b�h��Delete()���\�b�h�ł������ꍇ�ɌĂяo����郁�\�b�h)
	�ϐ���req,res
	throws��ServletException��IOException
	*/
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException,ServletException{
		//doPost��req,res���Ăт���
		doPost(req,res);
	}
	/*
	�ǂ̃N���X������A�N�Z�X�ł���悤��public
	HttpServlet�N���XdoPost()�̃��\�b�h���I�[�o�[���C�h��������
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException{
		
		//�����R�[�h�̐ݒ�B�ϐ�req
		req.setCharacterEncoding("utf-8");
		
		/*
		Map�N���X�^�̕ϐ�data��錾����
		Map�N���X����request����getParameterMap()���\�b�h�Ńp�����[�^���󂯎��
		
		Map data=req.getParameterMap();
		*/
		ApplicationController app = new WebApplicationController();
		
		RequestContext reqc = app.getRequest(req);
		
		ResponseContext resc = app.handleRequest(reqc);
		
		resc.setResponse(res);
		app.handleResponse(reqc, resc);
		/*
		String�N���X�^�̕ϐ�path��錾����
		String�N���X����getServletPath()���\�b�h�ŃT�[�u���b�g�p�X���擾��
		ConcreteCommand���擾
		*/
		//String path=req.getServletPath();
		
		/*
		AbstractCommand�N���X�^�̕ϐ�command��錾��
		AbstractCommand�N���X����getCommand()���\�b�h�Ńp�����[�^���󂯎��
		*/
		//AbstractCommand command = CommandFactory.getCommand(path);
		
		/*
		�C���X�^���X�̏���쐬���Ɏ��s���邩��init()���\�b�h
		�R�A�����ɓ��̓p�����[�^(data)��n��
		*/
		//command.init(data);
		
		/*
		�R�A���������s���A�߂�l�Ƃ���View�̏����擾����
		String�N���X�^�̕ϐ�url��錾��
		String�N���X����execute()���\�b�h�Ńp�����[�^���󂯎���ăR�A���������s
		*/
		//String url=command.execute();
		
		/*
		�R�A���������s���ʂ��擾���A�o�^�������s��
		jsp�ł̕\���ɗ��p
		Object�N���X�^�̕ϐ�result��錾��getResult()���\�b�h�Ńp�����[�^���󂯎����
		���s���ʂ��擾�A�o�^�������s��
		*/
		//Object result=command.getResult();
		
		/*
		setAttribute()���\�b�h��request���ꂽ�p�����[�^��result�Ɋi�[
		*/
		//req.setAttribute("result",result);
		
		/*
		RequsetDispacther�N���X�^�̕ϐ�dispatcher��錾��getRequestDispatcher()���\�b�h��url���擾
		*/
		//RequestDispatcher dispatcher=req.getRequestDispatcher(url);
		
		/*
		�]����ɗv����]������
		forward()���\�b�h�ɕϐ�req�Ares���i�[��dispatcher�ɕԂ�
		*/
		//dispatcher.forward(req,res);
	}
}
