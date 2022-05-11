import numpy as np
import sys


def parse_line(line):
    if len(line) < 2:
        return np.nan, 0, np.asarray([0, 0, 0, 0])
    alist = line.strip().split()
    for i in range(len(alist)):
        alist[i] = int(alist[i])
    alist = np.asarray(alist)
    if np.sum(alist) < 3:
        return np.nan, 0, alist[:4]
    z = np.argmax(alist[:4])  # 0,1,2,3
    if alist[z] / np.sum(alist) > .75:
        return z, np.sum(alist), alist[:4]
    return np.nan, 0, alist[:4]


def parse_map_file(filename):
    count = 0
    vector = np.zeros(16569)
    full_data = np.zeros((16569, 4))
    vector[vector > -1] = np.nan
    reads = list()
    with open(filename) as fp:
        for line in fp:
            if count > 0:
                vector[count - 1], num_reads, breakdown_for_bp = parse_line(line)
                full_data[count - 1, :] = np.squeeze(breakdown_for_bp)
                if num_reads > 0:
                    reads.append(num_reads)
            count += 1
    return full_data


def get_num_from_hist(bp_hist):
    if np.sum(bp_hist) < 3:
        return 'N'
    z = np.argmax(bp_hist)  # 0,1,2,3
    if bp_hist[z] / np.sum(bp_hist) > .75:
        return str(z)
    return 'N'


def breakdown_to_string(breakdown):
    chr_m_string = ""
    for row in breakdown:
        chr_m_string += get_num_from_hist(row)
    return chr_m_string


if __name__ == "__main__":
    print(breakdown_to_string(parse_map_file(sys.argv[1])))
