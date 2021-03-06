package basic.exam06.HW;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class LecturePanel extends ContentPanel{
	Date sqlDate = new Date(new java.util.Date().getTime());
	DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	String curDate = sdFormat.format(sqlDate);
	LectureControl controller = new LectureControl();

	List listView = new List(){
		public Dimension getPreferredSize() {
			return new Dimension(300, 400);
		};
	};

	Panel detailView = new Panel(new FlowLayout(FlowLayout.LEFT));
	TextField tfTitle = new TextField(10);
	TextField tfTeacher = new TextField(10);
	JFormattedTextField tfStartDate = new JFormattedTextField();
	JFormattedTextField tfEndDate = new JFormattedTextField();
	//TextField tfStartDate = new TextField(15);
	//TextField tfEndDate = new TextField(15);
	Choice tfClassRoom = new Choice();
	Choice tfManager = new Choice();
	Choice tfHours = new Choice();


	Panel newButtonBar;
	Panel detailButtonBar;
	Button btnAdd = new Button("등록");
	Button btnUpdate = new Button("변경");
	Button btnDelete = new Button("삭제");
	Button btnCancel = new Button("취소");

	int selectedIndex = -1;

	public LecturePanel(){
		super("점수관리");

		dateMaskForm(tfStartDate);
		dateMaskForm(tfEndDate);

		tfClassRoom.add("3-1");
		tfClassRoom.add("3-2");
		tfClassRoom.add("4-1");
		tfClassRoom.add("4-2");
		tfClassRoom.add("5-1");
		tfClassRoom.add("5-2");

		tfHours.add("1");
		tfHours.add("2");
		tfHours.add("3");
		tfHours.add("4");
		tfHours.add("5");
		tfHours.add("6");
		tfHours.add("7");
		tfHours.add("8");
		tfHours.add("9");
		tfHours.add("10");
		tfHours.add("11");
		tfHours.add("12");
		
		tfManager.add("구상현");
		tfManager.add("노의현");
		tfManager.add("박용범");
		tfManager.add("이강진");
		tfManager.add("김승범");
		tfStartDate.setColumns(10);
		tfEndDate.setColumns(10);

		listView.setMultipleMode(false);
		listView.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {

				Lecture l = Lecture.fromCSV(
						listView.getItem(
								listView.getSelectedIndex()));
				tfTitle.setText(l.title);
				tfTeacher.setText(l.teacher);
				tfStartDate.setText(l.startDate);
				tfEndDate.setText(l.endDate);
				tfClassRoom.select(l.classRoom);
				tfManager.select(l.manager);   
				tfHours.select(Integer.toString(l.hours));
				newButtonBar.setVisible(false);
				detailButtonBar.setVisible(true);
				LecturePanel.this.validate();

				selectedIndex = listView.getSelectedIndex();
			}
		});
		content.add(listView);
		detailView.setPreferredSize(new Dimension(300,400));

		Panel rowPane = new Panel(new FlowLayout(FlowLayout.LEFT));
		rowPane.setPreferredSize(new Dimension(290, 40));
		rowPane.add(createLabel("과목"));
		rowPane.add(tfTitle);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("강사"));
		rowPane.add(tfTeacher);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("시작일"));
		rowPane.add(tfStartDate);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("종료일"));
		rowPane.add(tfEndDate);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("교실"));
		rowPane.add(tfClassRoom);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("관리자"));
		rowPane.add(tfManager);
		detailView.add(rowPane);

		rowPane = createRowPane();
		rowPane.add(createLabel("일 강의시간"));
		rowPane.add(tfHours);
		detailView.add(rowPane);

		newButtonBar = createRowPane();
		newButtonBar.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lecture l = new Lecture();
				Lecture start = Lecture.fromCSV2(tfStartDate.getText());
				Lecture end = Lecture.fromCSV2(tfEndDate.getText());
				Lecture current = Lecture.fromCSV2(curDate);
				int startNum = start.year * 10000 + start.month * 100 + start.day; 
				int endNum = end.year * 10000 + end.month * 100 + end.day;
				boolean invalidStart = validateDateFormat(tfStartDate.getText());
				boolean invalidEnd = validateDateFormat(tfEndDate.getText());
		
				if(startNum < endNum && invalidStart == false && invalidEnd == false){
					if(start.year >= current.year ){	
						l.title = tfTitle.getText();
						l.teacher = tfTeacher.getText();
						l.startDate = tfStartDate.getText();
						l.endDate = tfEndDate.getText();
						l.classRoom = tfClassRoom.getSelectedItem();
						l.manager = tfManager.getSelectedItem();
						l.hours = Integer.parseInt(tfHours.getSelectedItem());
						controller.add(l);
						listView.add(l.toString());
						clearForm();
					}else{
						JOptionPane.showMessageDialog(null,"2014년이전 입력불가!");
					}
				}else{
					JOptionPane.showMessageDialog(null,"유효하지 않은 날짜입니다.");
				}
			}
		});		
		detailView.add(newButtonBar);

		detailButtonBar = createRowPane();
		detailButtonBar.setVisible(false);
		detailButtonBar.add(btnUpdate);
		detailButtonBar.add(btnDelete);
		detailButtonBar.add(btnCancel);

		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lecture l = new Lecture();
				l.title = tfTitle.getText();
				l.teacher = tfTeacher.getText();
				l.startDate = tfStartDate.getText();
				l.endDate = tfEndDate.getText();
				l.classRoom = tfClassRoom.getSelectedItem();
				l.manager = tfManager.getSelectedItem();
				l.hours = Integer.parseInt(tfHours.getSelectedItem());
				controller.add(l);
				controller.update(selectedIndex, l);
				listView.replaceItem(l.toString(), selectedIndex);

			}
		});
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newButtonBar.setVisible(true);
				detailButtonBar.setVisible(false);
				listView.remove(selectedIndex);
				controller.remove(selectedIndex);
				clearForm();
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newButtonBar.setVisible(true);
				detailButtonBar.setVisible(false);
				selectedIndex = -1;
				clearForm();
			}
		});
		detailView.add(detailButtonBar);
		content.add(detailView);
		controller.load();
		displayList();
	}	
	private void clearForm() {
		tfTitle.setText("");
		tfTeacher.setText("");
		tfStartDate.setText(null);
		tfEndDate.setText(null);
	}

	public final boolean validateDateFormat(final String date) {
		String[] formatStrings = {"yyyy-MM-dd"};
		boolean isInvalidFormat = false;
		Date dateObj;
		for (String formatString : formatStrings) {
			try {
				SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateInstance();
				sdf.applyPattern(formatString);
				sdf.setLenient(false);
				dateObj = sdf.parse(date);
				System.out.println(dateObj);
				if (date.equals(sdf.format(dateObj))) {
					isInvalidFormat = false;
					break;
				}
			} catch (ParseException e) {
				isInvalidFormat = true;
			}
		}
		return isInvalidFormat;
	}
	
	
	private void displayList() {
		for (Lecture lecture : controller.lectureList) {
			listView.add(lecture.toString());
		}
	}

	private Panel createRowPane() {
		Panel rowPane = new Panel(new FlowLayout(FlowLayout.LEFT));
		rowPane.setPreferredSize(new Dimension(290, 40));
		return rowPane;
	}

	private Label createLabel(String title) {
		Label label = new Label(title);
		label.setPreferredSize(new Dimension(70, 30));
		return label;
	}

	private static void dateMaskForm(JFormattedTextField value){
		MaskFormatter dateMask;
		try {
			dateMask = new MaskFormatter("####-##-##");
			dateMask.install(value);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
	}

	public void save() {
		controller.save();
	}
}


