package com.zhou.controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 用于生成验证码,并保存在session对象中
 */
@WebServlet("/DrawImage")
public class DrawImage extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 30;
	// 在报java.lang.NoClassDefFoundError: Could not initialize class
	// javax.imageio.ImageIO错的时候加上这个很管用。
	static
	{
		ImageIO.scanForPlugins();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("image/jpeg");
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// 创建缓存
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 获得画布
		Graphics g = bi.getGraphics();
		// 设置背影色
		setBackGround(g);
		// 设置边框
		setBorder(g);
		// 画干扰线
		drawRandomLine(g);
		// 写随机数
		String random = drawRandomNum((Graphics2D) g);
		// 将随机汉字存在session中
		request.getSession().setAttribute("ckimg", random);
		// 将图形写给浏览器
		
		// 发头控制浏览器不要缓存
		
		// 将图片写给浏览器
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}
	/**
	 * 设置背景色
	 * 
	 * @param g
	 */
	private void setBackGround(Graphics g)
	{
		// 设置颜色
		g.setColor(new Color(249, 249, 249));
		// 填充区域
		g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	/**
	 * 设置边框
	 * 
	 * @param g
	 */
	private void setBorder(Graphics g)
	{
		// 设置边框颜色
		// RGB
		g.setColor(new Color(210, 209, 205));
		// 边框区域
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
	}
	/**
	 * 画随机线条
	 * 
	 * @param g
	 */
	private void drawRandomLine(Graphics g)
	{
		// 设置颜色
		g.setColor(Color.GRAY);
		// 设置线条个数并画线
		/*for (int i = 0; i < 5; i++)
		{
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}*/
		//这样是一条贯穿横线
		int y1 = HEIGHT/2;
		int x2 = WIDTH-8;
		int y2 =HEIGHT/2;
		int x1 =4;
		g.drawLine(x1, y1, x2, y2);
	}
	/**
	 * 画随机值
	 * 
	 * @param g
	 * @return
	 */
	private String drawRandomNum(Graphics2D g)
	{
		StringBuffer sb = new StringBuffer();
		// 设置字体
		g.setFont(new Font("宋体", Font.BOLD, 20));
		
		String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int x = 5;
		// 控制字数
		for (int i = 0; i < 4; i++)
		{
			// 生成0-255的随机数
			int R = new Random().nextInt(256);
			int G = new Random().nextInt(256);
			int B = new Random().nextInt(256);
			// 设置每个随机数的颜色
			g.setColor(new Color(R, G, B));
			// 设置字体旋转角度
			int degree = new Random().nextInt() % 30;
			// 截取汉字
			String ch = base.charAt(new Random().nextInt(base.length())) + "";
			sb.append(ch);
			// 正向角度
			g.rotate(degree * Math.PI / 180, x, 20);
			g.drawString(ch, x, 20);
			// 反向角度
			g.rotate(-degree * Math.PI / 180, x, 20);
			x += 30;
		}
		return sb.toString();
	}
}
