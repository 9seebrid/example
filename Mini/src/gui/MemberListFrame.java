package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.MemberDao;
import model.Member;
import util.Sample;

public class MemberListFrame extends JFrame {

    private String username; // 세션값
    private JPanel contentPane;
    private JPanel southPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberListFrame frame = new MemberListFrame();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MemberListFrame() {
        this(null);
    }

    public MemberListFrame(String username) {
        this.username = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1032, 584);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel label = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
        label.setFont(new Font("굴림", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.NORTH);

        southPanel = new JPanel(new GridLayout(1, 2));
        JButton btnDelete = new JButton("삭제");
        JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
        southPanel.add(btnDelete);
        southPanel.add(btnLogout);
        contentPane.add(southPanel, BorderLayout.SOUTH);

        btnLogout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
                dispose();
                new LoginFrame();
            }
        });

        // JTable 데이터 매핑하기 (데이터, 칼럼이름, 테이블모델)
        // 1. 칼럼이름
        Vector<String> memberName = Sample.getMemberName();
        // 2. 데이터
        MemberDao dao = MemberDao.getInstance();
        Vector<Member> members = dao.findByAll();
        // 3. 테이블모델
        DefaultTableModel tableModel = new DefaultTableModel(memberName, 0);

        // 4. for문 돌면서 한 행씩 데이터 집어 넣기
        for (int i = 0; i < members.size(); i++) {
            Vector<Object> row = new Vector<>();
            row.addElement(members.get(i).getId());
            row.addElement(members.get(i).getUsername());
            row.addElement(members.get(i).getPassword());
            row.addElement(members.get(i).getName());
            row.addElement(members.get(i).getEmail());
            row.addElement(members.get(i).getPhone());
            row.addElement(members.get(i).getCreateDate());
            tableModel.addRow(row); // table모델에 행 넣기
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        contentPane.add(scrollPane, BorderLayout.CENTER);

        btnDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                //행이 선택되지 않으면 row는 -1이 됨.
                if(row < 0) {
                    row = table.getRowCount()-1;
                }
                Object id = table.getValueAt(row, 0);
                //UI제거
                tableModel.removeRow(row);
                //DB제거
                MemberDao dao = MemberDao.getInstance();
//                dao.delete((int)id);
            }
        });

        if (username == null) {
            JOptionPane.showMessageDialog(null, "인증되지 않은 사용자입니다.");
            dispose();
        } else {
            setVisible(true);
        }
    }

}

